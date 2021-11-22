package com.example.reservation.service.Impl;

import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.service.MemberDomainService;
import com.example.reservation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final MemberDomainService memberDomainService;

    public UserServiceImpl(MemberDomainService memberDomainService) {
        this.memberDomainService = memberDomainService;
    }

    public void joinMember(User user) {
        boolean isEmail = memberDomainService.checkEmail(user.getEmail());
        boolean isPhoneNumber = memberDomainService.checkPhoneNumber(user.getPhoneNumber());


        User newUser = memberDomainService.saveUser(user, isEmail, isPhoneNumber);

        String saveStatus = newUser.getSaveStatus();
        log.info("{} 회원 가입 {}", user.getEmail(), saveStatus );
    }
 }
