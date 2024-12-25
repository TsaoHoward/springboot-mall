package com.example.springbootmybatis.dto;

import jakarta.validation.constraints.NotNull;

public class OrderItemDto {

    @NotNull
    Integer productId;

    @NotNull
    Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
