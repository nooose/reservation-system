package com.example.reservation.service;


import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.entity.Member;

public interface LoginService {

    Member login(LoginForm loginForm);
    void logout();
}
