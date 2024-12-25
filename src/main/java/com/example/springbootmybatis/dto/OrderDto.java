package com.example.springbootmybatis.dto;

import java.util.List;

public class OrderDto {

    private Integer orderId;
    private Integer userId;
    private Long totalAmount;

//    @NotEmpty
    private List<OrderItemDto> orderItemDtoList;

    private Integer limit;
    private Integer offset;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDto> getBuyItemList() {
        return orderItemDtoList;
    }

    public void setBuyItemList(List<OrderItemDto> orderItemDtoList) {
        this.orderItemDtoList = orderItemDtoList;
    }
}
