package com.example.reservation.domain.dto.web;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class MemberForm {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password1;

    @NotBlank
    private String password2;

    @NotBlank
    private String nickName;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String city;

    @NotBlank
    private String street;
}
