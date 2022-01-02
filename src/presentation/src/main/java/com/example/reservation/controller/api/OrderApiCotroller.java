package com.example.reservation.controller.api;


import com.example.reservation.domain.dto.api.*;
import com.example.reservation.domain.entity.Order;
import com.example.reservation.service.Impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderApiCotroller {

    private final OrderServiceImpl orderService;

    /**
     * 주문 생성
     * @param userId
     * @param itemId
     * @param reqeustOrderDto
     * @return
     */
    @PostMapping("/{userId}/{itemId}")
    public ResponseOrderDto<ResponseUserDto, ItemDto, OrderDto> createOrder(@PathVariable Long userId,
                                                                            @PathVariable Long itemId,
                                                                            @RequestBody ReqeustOrderDto reqeustOrderDto) {

        Order order = orderService.createOrder(userId, itemId, reqeustOrderDto);

        ResponseUserDto responseUserDto = order.getUser().toResponseDto();
        ItemDto itemDto = order.getItem().toDto();
        OrderDto orderDto = order.toResponseDto();

        return new ResponseOrderDto<>(responseUserDto, itemDto, orderDto);
    }

    /**
     * 회원의 주문내역 리스트
     * @return
     */
    @GetMapping("/user/{userId}")
    public ResponseOrderListDto<List<OrderDto>> getOrderList(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrderList(userId);

        String userName = orders.get(0).getUser().getName();

        List<OrderDto> orderDtoList = orders.stream()
                .map(Order::toResponseDto).collect(Collectors.toList());
        return new ResponseOrderListDto<>(orderDtoList.size(), userName, orderDtoList);
    }


    /**
     * 주문 취소
     * @param orderId
     * @return
     */
    @DeleteMapping("/{orderId}")
    public OrderDto cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);

        return orderService.findOrder(orderId).toResponseDto();
    }




}
