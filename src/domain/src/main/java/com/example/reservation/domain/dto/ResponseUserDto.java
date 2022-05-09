package com.example.reservation.domain.dto;


import lombok.Data;

@Data
public class ResponseUserDto {
    private String email;
    private String nickName;
    private String name;
    private int point;
}
