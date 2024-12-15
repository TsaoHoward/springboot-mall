package com.howard.springbootmall.service;

import com.howard.springbootmall.dto.CreateOrderRequest;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    @Transactional
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
