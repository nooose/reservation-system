package com.example.reservation.controller.web;

import com.example.reservation.domain.dto.ResponseUserDto;
import com.example.reservation.domain.dto.web.LoginForm;
import com.example.reservation.domain.service.login.LoginDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginDomainService loginService;


    @GetMapping
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form,
                        HttpServletRequest request, HttpServletResponse response, Model model) {
        ResponseUserDto loginMember = loginService.login(form, request, response);
        if (loginMember == null) {
            return "home/index";
        }

        model.addAttribute("loginMember", loginMember);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
