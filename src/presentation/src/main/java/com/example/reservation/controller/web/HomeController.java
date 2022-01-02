package com.example.reservation.controller.web;

import com.example.reservation.domain.dto.ResponseUserDto;
import com.example.reservation.domain.entity.Member;
import com.example.reservation.domain.vo.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping
    public String index(
            @SessionAttribute(value = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home/index";
        }

        //세션이 유지되면 로그인으로 이동
        ResponseUserDto responseUserDto = loginMember.toUserObject().toResponseDto();
        model.addAttribute(SessionConst.LOGIN_MEMBER, responseUserDto);
        return "home/loginHome";
    }
}
