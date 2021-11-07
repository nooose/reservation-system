package com.example.reservation.domain.entity;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(false)
class UserTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("user 저장 및 조회 테스트")
    void findUserTest(){
        // given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        User user = User.builder()
                .id(1L)
                .email("test@test.com")
                .password("12345")
                .nickName("test")
                .name("test")
                .phoneNumber("010-1234-5678")
                .address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();
        
        // when
        memberRepository.save(user);
        Member findUser = memberRepository.findById(user.getId()).get();

        // then
        System.out.println("findUser = " + findUser);
    }

    @Test
    @DisplayName("JPA Audit 테스트")
    void auditTest(){
        // given
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        User user = User.builder()
                .id(1L)
                .email("test@test.com")
                .password("12345")
                .nickName("test")
                .name("test")
                .phoneNumber("010-1234-5678")
                .address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();
        
        // when
        memberRepository.save(user);
        Member findUser = memberRepository.findById(user.getId()).get();
        
        //then
        System.out.println("findUser.getCreatedAt() = " + findUser.getCreatedAt());
        System.out.println("findUser.getLastLogin() = " + findUser.getLastLogin());
    }
}