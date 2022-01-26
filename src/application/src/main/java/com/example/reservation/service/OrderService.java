package com.example.reservation.service;

import com.example.reservation.domain.dto.ReqeustOrderDto;
import com.example.reservation.domain.entity.Order;


public interface OrderService {
    Order createOrder(Long userId, Long itemId, ReqeustOrderDto reqeustOrderDto);

    void createOrder(Long userId, Long itemId);

    void cancelOrder(Long orderId);

    Order findOrder(Long orderId);
}
