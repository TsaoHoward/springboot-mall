package com.example.springbootmybatis.po;

import jakarta.annotation.Generated;
import java.util.Date;

public class Order {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer orderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer totalAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date lastModifiedDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getOrderId() {
        return orderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTotalAmount() {
        return totalAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreatedDate() {
        return createdDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}