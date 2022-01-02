package com.example.reservation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReqeustOrderDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
