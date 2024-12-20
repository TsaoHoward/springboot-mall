package com.example.springbootmybatis.entity;

import java.util.Date;

public class Product_old {
    private Integer productId;
    private String productName;
    private String category;
    private String description;
    private Integer price;
    private String imageUrl;
    private Integer stock;
    private Date createdDate;
    private Date lastModifiedDate;

//    @JsonIgnore
//    private Integer limit;
//    @JsonIgnore
//    private Integer offset;


    public Product_old() {
    }

    public Product_old(Integer productId, String productName, String category,
                       String imageUrl, Integer price, Integer stock, String description) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = stock;
        this.description = description;
//        this.limit = limit;
//        this.offset = offset;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
//
//    public Integer getLimit() {
//        return limit;
//    }
//
//    public void setLimit(Integer limit) {
//        this.limit = limit;
//    }
//
//    public Integer getOffset() {
//        return offset;
//    }
//
//    public void setOffset(Integer offset) {
//        this.offset = offset;
//    }
}
