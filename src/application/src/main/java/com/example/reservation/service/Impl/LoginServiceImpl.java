package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.service.login.LoginDomainService;
import com.example.reservation.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDomainService loginDomainService;

    @Override
    public Optional<Member> login(LoginForm loginForm) {
        return loginDomainService.login(loginForm);
    }

    @Override
    public void logout() {

    }
}
