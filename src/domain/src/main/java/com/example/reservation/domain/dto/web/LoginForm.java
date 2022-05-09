package com.example.reservation.domain.dto.web;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @NotBlank(message = "이메일을 입력하세요.")
    private String email;
    @NotBlank(message = "패스워드를 입력하세요")
    private String password;
}
