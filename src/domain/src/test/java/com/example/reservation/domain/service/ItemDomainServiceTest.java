package com.example.reservation.domain.service;

import com.example.reservation.domain.dto.web.CompanyForm;
import com.example.reservation.domain.dto.web.ItemForm;
import com.example.reservation.domain.dto.web.UserForm;
import com.example.reservation.domain.entity.Company;
import com.example.reservation.domain.entity.Item;
import com.example.reservation.domain.entity.Order;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.ItemRepository;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class ItemDomainServiceTest {

    @Autowired ItemDomainService itemDomainService;
    @Autowired ItemRepository itemRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired OrderService orderService;


    @Test
    @DisplayName("아이템 2개 등록 및 주문")
    public void saveItemTest() {
        // 상품 등록
        // given
        CompanyForm companyForm = new CompanyForm("company@test.com", "1234", "1234",
                "축구회사", "김영철",
                "010-1234-5678", "서울시", "동남로");
        Company company = companyForm.toEntity();
        memberRepository.save(company);
        Company findCompany = (Company) memberRepository.findByEmail("company@test.com")
                                                            .orElseGet(() -> null);


        LocalTime startTime1 = LocalTime.of(9, 0, 0);
        LocalTime endTime1 = LocalTime.of(18, 0, 0);
        ItemForm itemForm1 = new ItemForm("테스트 상품A", "테스트입니다.", 10000, startTime1, endTime1);
        Item item1 = itemForm1.toEntity();

        LocalTime startTime2 = LocalTime.of(9, 0, 0);
        LocalTime endTime2 = LocalTime.of(14, 0, 0);
        ItemForm itemForm2 = new ItemForm("테스트 상품B", "테스트입니다.", 10000, startTime2, endTime2);
        Item item2 = itemForm2.toEntity();

        item1.setCompany(findCompany);
        item2.setCompany(findCompany);


        // when
        itemDomainService.saveItem(item1);
        itemDomainService.saveItem(item2);

        Company resultCompany = (Company) memberRepository.findByEmail("company@test.com")
                                                            .orElseGet(() -> null);
        Item findItem1 = resultCompany.getItems().get(0);
        Item findItem2 = resultCompany.getItems().get(1);

        // then
        assertThat(findItem1.getTitle()).isEqualTo("테스트 상품A");
        System.out.println(findItem2.getTitle() + " 시간 " + findItem1.getStartTime() + "~" + findItem1.getEndTime());

        assertThat(findItem2.getTitle()).isEqualTo("테스트 상품B");
        System.out.println(findItem2.getTitle() + " 시간 " + findItem2.getStartTime() + "~" + findItem2.getEndTime());


        // 상품 주문
        // given
        UserForm userForm = new UserForm("user@test.com", "1234", "1234",
                "noose", "성준혁",
                "010-7236-1800", "서울시", "동남로");
        User user = userForm.toUserEntity();
        memberRepository.save(user);

        User findUser1 = (User) memberRepository.findByEmail("user@test.com").get();
        Order order1 = orderService.createOrder(findUser1.getId(), findItem1.getId());
        Order order2 = orderService.createOrder(findUser1.getId(), findItem2.getId());


        // when
        orderService.order(order1);
        orderService.order(order2);

        // then
        User findUser2 = (User) memberRepository.findByEmail("user@test.com").get();

        List<Order> orders = findUser2.getOrders();
        Order result1 = orders.get(0);
        Order result2 = orders.get(1);

        assertThat(result1.getItem().getTitle()).isEqualTo("테스트 상품A");
        System.out.println(order1.getUser().getName() + "님의 주문 상품 = " + order1.getItem().getTitle());

        assertThat(result2.getItem().getTitle()).isEqualTo("테스트 상품B");
        System.out.println(order2.getUser().getName() + "님의 주문 상품 = " + order2.getItem().getTitle());
    }
}