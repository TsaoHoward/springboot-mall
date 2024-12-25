package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.OrderDto;
import com.example.springbootmybatis.service.OrderService;
import com.example.springbootmybatis.vo.OrderListVo;
import com.example.springbootmybatis.vo.OrderVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId, @RequestBody @Valid OrderDto orderDto){

        Integer orderId = orderService.createOrder(userId, orderDto);

        OrderVo orderVo = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderVo);
    }

    @GetMapping("users/{userId}/orders")
    public ResponseEntity<?> getOrders(
            @PathVariable Integer userId
            , @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit
            , @RequestParam(defaultValue = "0") @Min(0) Integer offset){
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(userId);
        orderDto.setLimit(limit);
        orderDto.setOffset(offset);
        Long count = orderService.count(orderDto);
        orderDto.setTotalAmount(count);



        OrderListVo orderList = orderService.getOrders(orderDto);


//        Page<Order> page = new Page<>();
//        page.setLimit(limit);
//        page.setOffset(offset);
//        page.setTotal(count);
//        page.setResults(orderList);

//        return ResponseEntity.status(HttpStatus.OK).body(page);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);

    }


}
