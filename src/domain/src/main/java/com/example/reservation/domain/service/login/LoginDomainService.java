package com.example.reservation.domain.service.login;

import com.example.reservation.domain.dto.ResponseUserDto;
import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.vo.SessionConst;
import com.example.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginDomainService {

    private final MemberRepository memberRepository;

    public ResponseUserDto login(LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
        Member loginMember = memberRepository.findByEmail(loginForm.getEmail()).stream()
                .filter(m -> m.getPassword().equals(loginForm.getPassword()))
                .findFirst().orElse(null);

        if (loginMember == null) {
            log.info("회원 정보를 찾을 수 없습니다.");
            return null;
        }

        //로그인 성공
        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return loginMember.toUserObject().toResponseDto();
    }


}
