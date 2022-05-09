package com.example.reservation.service;


import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.entity.Member;

import java.util.Optional;

public interface LoginService {

    Optional<Member> login(LoginForm loginForm);
    void logout();
}
