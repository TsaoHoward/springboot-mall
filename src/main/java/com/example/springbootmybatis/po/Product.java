package com.example.springbootmybatis.po;

import jakarta.annotation.Generated;
import java.util.Date;

public class Product {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer productId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String productName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String category;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String imageUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer stock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createdDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date lastModifiedDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getProductId() {
        return productId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getProductName() {
        return productName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategory() {
        return category;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getImageUrl() {
        return imageUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStock() {
        return stock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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