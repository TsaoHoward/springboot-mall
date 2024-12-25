package com.example.springbootmybatis.vo;

import com.example.springbootmybatis.po.OrderItem;

import java.util.List;

public class OrderVo {
    Integer orderId;
    Integer totalAmount;
    Integer userId;
    List<?> orderItemList;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<?> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<?> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
