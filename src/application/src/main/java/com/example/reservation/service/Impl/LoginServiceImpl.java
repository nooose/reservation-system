package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.service.UserDomainServiceImpl;
import com.example.reservation.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final UserDomainServiceImpl userDomainService;

    @Override
    public void login(LoginForm loginForm, HttpServletRequest request) {
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
    }

    @Override
    public void logout() {

    }
}
