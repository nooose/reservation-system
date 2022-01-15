package com.example.reservation.domain.dto.web;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class MemberForm {

    @NotBlank
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @NotBlank(message = "이메일을 입력하세요.")
    private String email;

    @NotEmpty(message = "패스워드를 입력하세요")
    private String password1;

    @NotBlank(message = "패스워드 확인을 입력하세요")
    private String password2;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickName;

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    @NotBlank(message = "핸드폰 번호를 입력하세요.")
    private String phoneNumber;

    @NotBlank(message = "도시를 입력하세요")
    private String city;

    @NotBlank(message = "도로명을 입력하세요.")
    private String street;
}
