package com.example.reservation.domain.dto;


import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private String nickName;
    private String name;
    private String phoneNumber;
}
