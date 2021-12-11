package com.example.reservation.service.Impl;

import com.example.reservation.domain.dto.ReqeustOrderDto;
import com.example.reservation.domain.entity.Item;
import com.example.reservation.domain.entity.Order;
import com.example.reservation.domain.entity.User;
import com.example.reservation.domain.service.ItemDomainService;
import com.example.reservation.domain.service.OrderDomainService;
import com.example.reservation.domain.type.OrderStatusType;
import com.example.reservation.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final UserServiceImpl userService;
    private final ItemDomainService itemDomainService;
    private final OrderDomainService orderDomainService;

    @Override
    @Transactional
    public Order createOrder(Long userId, Long itemId, ReqeustOrderDto reqeustOrderDto) {
        User user = userService.getMember(userId).toUserObject();
        Item item = itemDomainService.getItem(itemId);

        Order order = new Order();
        order.setUser(user);
        order.setItem(item);
        order.setStartTime(reqeustOrderDto.getStartTime());
        order.setEndTime(reqeustOrderDto.getEndTime());
        order.setOrderStatus(OrderStatusType.COMPLETE);

        orderDomainService.save(order);

        return order;
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = findOrder(orderId);
        order.setOrderStatus(OrderStatusType.CANCEL);
    }



    @Override
    @Transactional(readOnly = true)
    public Order findOrder(Long orderId) {
        return orderDomainService.findById(orderId);
    }


    public List<Order> getOrderList(Long userId) {
        User findUser = userService.getMember(userId).toUserObject();
        return findUser.getOrders();
    }
}