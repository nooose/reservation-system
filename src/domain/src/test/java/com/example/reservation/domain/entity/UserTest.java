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
import java.util.Date;

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
        User user = new User(1L, "test@test.com", "12345",
                "test", "test", "010-1234-5678",
                address,new Date(), MemberRole.BASIC, 100);

        // when
        memberRepository.save(user);
        Member findUser = memberRepository.findById(user.getId()).get();

        // then
        System.out.println("findUser = " + findUser);
    }
}