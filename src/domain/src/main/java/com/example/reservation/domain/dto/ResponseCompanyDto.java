package com.example.reservation.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseCompanyDto {
    private String name;
    private String companyName;
    private List<ItemDto> items;
}
