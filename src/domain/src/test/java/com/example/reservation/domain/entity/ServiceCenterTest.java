package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.enumtype.ProcessType;
import com.example.reservation.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(value = false)
class ServiceCenterTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("서비스센터 조회 테스트 값이 있는 경우")
    void createServiceCenterTest(){
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
                .writer(user)
                .title("testTitle")
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();
        
        //when
        boardRepository.save(serviceCenter);
        Optional<Board> findServiceCenter = boardRepository.findById(2L);
        ServiceCenter findServiceCenterA = (ServiceCenter) findServiceCenter.orElseGet(() -> new ServiceCenter());

        //then
        System.out.println("=====");
        assertThat(findServiceCenterA.getProcess()).isEqualTo(ProcessType.PRE);

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
                .writer(user)
                .contents("내용테스트")
                .process(ProcessType.PRE)
                .category("공지글")
                .build();

        //when
        boardRepository.save(serviceCenter);
        Optional<Board> findServiceCenter = boardRepository.findById(2L);
        ServiceCenter findServiceCenterA = (ServiceCenter) findServiceCenter.orElseGet(() -> new ServiceCenter());

        //then
        System.out.println("=====");
        assertThat(findServiceCenterA.getTitle()).isNull();
    }

}