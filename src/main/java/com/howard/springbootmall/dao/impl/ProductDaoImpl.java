package com.howard.springbootmall.dao.impl;

import com.howard.springbootmall.dao.ProductDao;
import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Object ProductRowMapper;

    @Override
    public Integer createProduct(ProductRequest product) {

        String sql = "insert into product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) " +
                "VALUES(:productName, :category, :imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", product.getProductName());
        map.put("category", product.getCategory().toString());
        map.put("imageUrl", product.getImageUrl());
        map.put("price", product.getPrice());
        map.put("stock", product.getStock());
        map.put("description", product.getDescription());

        Date now =new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為: " + id);

        return id;
    }

    @Override
    public Integer updateProduct(Integer productId, ProductRequest product) {
        String sql = "UPDATE product " +
                "SET product_name=:productName, category=:category, image_url=:imageUrl, price=:price, stock=:stock, description=:description, last_modified_date=:lastModifiedDate " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", product.getProductName());
        map.put("category", product.getCategory().toString());
        map.put("imageUrl", product.getImageUrl());
        map.put("price", product.getPrice());
        map.put("stock", product.getStock());
        map.put("description", product.getDescription());

        Date now =new Date();
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
//
//        int id = keyHolder.getKey().intValue();
        System.out.println("id: " + productId+" modified.");

        return productId;
    }

    @Override
    public Product getProductById(Integer productId) {

        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date " +
                "FROM product " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0){
            return productList.get(0);
        }else{
            return null;
        }



    }


}