package com.example.reservation.service.Impl;

import com.example.reservation.domain.Address;
import com.example.reservation.domain.MemberRole;
import com.example.reservation.domain.entity.User;
import com.example.reservation.repository.MemberRepository;
import com.example.reservation.service.UserService;
import org.springframework.stereotype.Service;

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
        User userA = new User(1L, "test@test.com", "12345",
                "test", "test", "010-1234-5678",
                address,new Date(), MemberRole.BASIC, 100);

        User userB = new User(2L, "test@test.com", "12345",
                "test", "test", "010-1234-5678",
                address,new Date(), MemberRole.BASIC, 100);


        memberRepository.save(userA);
        memberRepository.save(userB);
    }
}
