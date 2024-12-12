package com.howard.springbootmall.dao;

import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.model.Product;

public interface ProductDao {

    Integer createProduct(ProductRequest product);

    Product getProductById(Integer productId);




}
