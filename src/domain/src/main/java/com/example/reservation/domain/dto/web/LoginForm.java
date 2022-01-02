package com.example.reservation.domain.dto.web;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
}
