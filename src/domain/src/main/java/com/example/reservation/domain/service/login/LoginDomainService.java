package com.example.reservation.domain.service.login;

import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.exception.MemberException;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginDomainService {

    private final MemberRepository memberRepository;

    public Member login(LoginForm loginForm) {

        return memberRepository.findByEmail(loginForm.getEmail()).stream()
                .filter(m -> m.getPassword().equals(loginForm.getPassword()))
                .findFirst().orElseThrow(() -> new MemberException("로그인 실패"));
    }

}
