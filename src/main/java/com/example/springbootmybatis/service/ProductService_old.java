package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Product_old;

import java.util.List;

public interface ProductService_old {
    Product_old findById(Integer id);
    Integer count(Product_old productOld);
    List<Product_old> findAll(Product_old productOld, Integer limit, Integer offset);
    Integer insertProduct(Product_old productOld);
    Product_old findByName(String name);
    Integer selectLastInsertId();
    void deleteById(Integer id);
    void updateById(Product_old productOld);
    void updateStockById(Product_old productOld);
}
