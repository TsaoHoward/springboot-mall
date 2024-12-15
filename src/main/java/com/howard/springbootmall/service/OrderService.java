package com.howard.springbootmall.service;

import com.howard.springbootmall.dto.CreateOrderRequest;
import com.howard.springbootmall.model.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    @Transactional
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    @Transactional
    Order getOrderById(Integer orderId);
}
