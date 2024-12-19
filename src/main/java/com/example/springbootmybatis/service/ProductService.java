package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(Integer id);
    Integer count(Product product);
    List<Product> findAll(Product product, Integer limit, Integer offset);
    Integer insertProduct(Product product);
    Product findByName(String name);
    Integer selectLastInsertId();
    void deleteById(Integer id);
    void updateById(Product product);
    void updateStockById(Product product);
}
