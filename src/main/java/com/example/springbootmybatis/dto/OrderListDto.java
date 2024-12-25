package com.example.springbootmybatis.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OrderListDto {


    @NotEmpty
    private List<OrderItemDto> orderItemDtoList;

    public List<OrderItemDto> getBuyItemList() {
        return orderItemDtoList;
    }

    public void setBuyItemList(List<OrderItemDto> orderItemDtoList) {
        this.orderItemDtoList = orderItemDtoList;
    }
}
