package com.example.reservation.service.Impl;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

//@Service
public class UserServiceImplV1 implements UserService {
    private final MemberRepository memberRepository;

    public UserServiceImplV1(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void testSaveUser() {
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

        memberRepository.save(user);
    }

    @Override
    public void testSaveuser2() {

    }

    @Override
    public void testSaveuser3() {

    }
}
