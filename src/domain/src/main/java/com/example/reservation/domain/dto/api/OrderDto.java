package com.example.reservation.domain.dto.api;

import com.example.reservation.domain.type.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {
    private String itemName;
    private OrderStatusType status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
