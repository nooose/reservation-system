package com.example.reservation.domain.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseOrderListDto<O>{
    private int count;
    private String userName;
    private O orders;
}
