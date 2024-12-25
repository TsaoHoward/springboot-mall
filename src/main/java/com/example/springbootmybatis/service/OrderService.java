package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.OrderListDto;
import com.example.springbootmybatis.dto.OrderQueryParams;
import com.example.springbootmybatis.po.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {

    @Transactional
    Integer createOrder(Integer userId, OrderListDto orderListDto);

    @Transactional
    Order getOrderById(Integer orderId);

    @Transactional
    Integer countOrders(OrderQueryParams orderQueryParams);

    @Transactional
    List<Order> getOrders(OrderQueryParams orderQueryParams);
}
