package com.example.springbootmybatis.po;

import jakarta.annotation.Generated;

public class OrderItem {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer orderItemId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer orderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer productId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer quantity;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer amount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOrderItemId() {
        return orderItemId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOrderId() {
        return orderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getProductId() {
        return productId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getQuantity() {
        return quantity;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getAmount() {
        return amount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}