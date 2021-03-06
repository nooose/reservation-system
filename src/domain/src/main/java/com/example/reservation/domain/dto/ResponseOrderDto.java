package com.example.reservation.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseOrderDto<U, I, O> {
    private U user;
    private I item;
    private O order;
}
