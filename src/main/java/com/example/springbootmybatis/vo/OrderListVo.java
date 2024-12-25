package com.example.springbootmybatis.vo;

import java.util.List;

public class OrderListVo {
    private Integer userId;
    private List<OrderVo> orderList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<OrderVo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderVo> orderList) {
        this.orderList = orderList;
    }
}
