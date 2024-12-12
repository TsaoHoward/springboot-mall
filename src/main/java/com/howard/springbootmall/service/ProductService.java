package com.howard.springbootmall.service;

import com.howard.springbootmall.model.Product;
import org.springframework.stereotype.Component;

public interface ProductService {
    Product getProductById(Integer productId);
}
