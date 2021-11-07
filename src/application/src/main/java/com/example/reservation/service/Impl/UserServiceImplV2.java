package com.example.reservation.service.Impl;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.enumtype.MemberRole;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImplV2 implements UserService {
    private final MemberRepository memberRepository;

    public UserServiceImplV2(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void testSaveUser() {
        Address address = new Address("Seoul", "test", "123-456");
        LocalDateTime now = LocalDateTime.now();

        User userA = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();

        User userB = User.builder()
                .id(1L)
                .email("test@test.com").password("12345")
                .nickName("test").name("test")
                .phoneNumber("010-1234-5678").address(address)
                .memberRole(MemberRole.BASIC)
                .lastLogin(now)
                .point(100).build();






        memberRepository.save(userA);
        memberRepository.save(userB);
    }
}
