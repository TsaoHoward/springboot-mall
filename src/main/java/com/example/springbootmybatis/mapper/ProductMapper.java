package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface ProductMapper {
    Product findById(Integer id);
    Integer count(Product product);
    List<Product> findAll(Map<String, Object> paramMap);
    void insertProduct(Product product);
    Product findByName(String name);
    Integer selectLastInsertId();
    void deleteById(Integer id);
    void updateById(Product product);
    void updateStockById(Product product);
}
