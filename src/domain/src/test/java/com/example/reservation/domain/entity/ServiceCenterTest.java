package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.enumtype.ProcessType;
import com.example.reservation.repository.BoardRepository;
import com.example.reservation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(value = false)
class ServiceCenterTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("서비스센터 조회 테스트 값이 있는 경우")
    void createServiceCenterTest(){
        //given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        List<Board> boardList = new ArrayList<>();
        User user = User.builder()
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .boards(boardList)
                .lastLogin(now)
                .point(100).build();

        memberRepository.save(user);

        ServiceCenter serviceCenter = ServiceCenter.builder()
                .title("testTitle")
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();

        user.getBoards().add(serviceCenter);
        serviceCenter.setMember(user);

        //when
        boardRepository.save(serviceCenter);
        Board board = boardRepository.findById(1L).get();

        //then
        System.out.println("=====");
        assertThat(board.getId()).isEqualTo(1L);

    }

    @Test
    @DisplayName("서비스센터 조회 테스트 값이 없는 경우")
    void createServiceCenterOptinalTest(){
        //given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();

        ServiceCenter serviceCenter = ServiceCenter.builder()
                .id(1L)
                .title("testTitle")
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();

        //when
        boardRepository.save(serviceCenter);
        Optional<Board> byId = boardRepository.findById(3L);

        if (byId.isPresent()) {
            System.out.println("값 존재합니다.");
        } else {
            System.out.println("값 없습니다.");
        }

        ServiceCenter findServiceCenter = (ServiceCenter) byId.orElseGet(() -> ServiceCenter.builder().build());

        //then
        System.out.println("=====");
        assertThat(findServiceCenter.getTitle()).isNull();
    }

}