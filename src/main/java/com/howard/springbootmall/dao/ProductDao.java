package com.howard.springbootmall.dao;

import com.howard.springbootmall.dto.ProductQueryParams;
import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer createProduct(ProductRequest product);

    Integer updateProduct(Integer productId, ProductRequest productRequest);

    Product getProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    void deleteProductById(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
