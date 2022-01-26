package com.example.reservation.domain.service;

import com.example.reservation.domain.entity.Order;
import com.example.reservation.repository.OrderRepostiroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OrderDomainService {

    private final OrderRepostiroy orderRepostiroy;

    public void save(Order order) {
        orderRepostiroy.save(order);
    }

    public Order findById(Long id) {
        Optional<Order> byId = orderRepostiroy.findById(id);
        return byId.orElseThrow(() -> new IllegalStateException("해당하는 주문이 없습니다."));
    }


}
