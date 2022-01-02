package com.example.reservation.controller.web;

import com.example.reservation.dto.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form) {

        System.out.println("form.getEmail() = " + form.getEmail());
        System.out.println("form.getPassword() = " + form.getPassword());

        return "login/loginForm";
    }

}
