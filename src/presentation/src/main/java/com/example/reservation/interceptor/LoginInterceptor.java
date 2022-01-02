package com.example.reservation.interceptor;

import com.example.reservation.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if (session == null) {
            log.info("세션이 없습니다.");
            return true;
        }


        Member loginMember = (Member) session.getAttribute("loginMember");

        log.info("현재 사용자={}", loginMember.getName());


        return true;
    }

}
