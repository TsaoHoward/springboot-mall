package com.howard.springbootmall.service;

import com.howard.springbootmall.dto.CreateOrderRequest;
import com.howard.springbootmall.dto.OrderQueryParams;
import com.howard.springbootmall.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    @Transactional
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    @Transactional
    Order getOrderById(Integer orderId);

    @Transactional
    Integer countOrders(OrderQueryParams orderQueryParams);

    @Transactional
    List<Order> getOrders(OrderQueryParams orderQueryParams);
}
