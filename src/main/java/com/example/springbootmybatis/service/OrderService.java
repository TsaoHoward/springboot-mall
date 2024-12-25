package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.OrderDto;
import com.example.springbootmybatis.vo.OrderListVo;
import com.example.springbootmybatis.vo.OrderVo;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional
    Integer createOrder(Integer userId, OrderDto orderDto);

    @Transactional
    OrderVo getOrderById(Integer orderId);

    @Transactional
    Long count(OrderDto orderDto);

    @Transactional
    OrderListVo getOrders(OrderDto orderDto);
}
