package com.example.reservation.service;


import com.example.reservation.domain.dto.web.LoginForm;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    void login(LoginForm loginForm, HttpServletRequest request);
    void logout();
}
