package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.OrderDto;
import com.example.springbootmybatis.service.OrderService;
import com.example.springbootmybatis.vo.OrderListVo;
import com.example.springbootmybatis.vo.OrderVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        // 模擬服務層行為
        when(orderService.createOrder(anyInt(), any(OrderDto.class))).thenReturn(1);
        when(orderService.getOrderById(1)).thenReturn(mockOrderVo());

        // 執行測試
        ResponseEntity<?> response = orderController.createOrder(1, new OrderDto());

        // 驗證結果
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(1, ((OrderVo) response.getBody()).getOrderId());

        // 驗證調用次數
        verify(orderService, times(1)).createOrder(anyInt(), any(OrderDto.class));
        verify(orderService, times(1)).getOrderById(1);
    }

    @Test
    void testGetOrders() {
        // 模擬服務層行為
        when(orderService.getOrders(any(OrderDto.class))).thenReturn(mockOrderListVo());

        // 執行測試
        ResponseEntity<?> response = orderController.getOrders(1, 10, 0);

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, ((OrderListVo) response.getBody()).getOrderList().size());

        // 驗證調用次數
        verify(orderService, times(1)).getOrders(any(OrderDto.class));
    }

    private OrderVo mockOrderVo() {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(1);
        orderVo.setTotalAmount(1000);
        return orderVo;
    }

    private OrderListVo mockOrderListVo() {
        OrderListVo orderListVo = new OrderListVo();
        orderListVo.setOrderList(List.of(mockOrderVo()));
        return orderListVo;
    }
}
