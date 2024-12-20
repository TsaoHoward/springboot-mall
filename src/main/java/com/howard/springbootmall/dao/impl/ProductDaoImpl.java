package com.howard.springbootmall.dao.impl;

import com.howard.springbootmall.dao.ProductDao;
import com.howard.springbootmall.dto.ProductQueryParams;
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
        map = mapSql(map, product);
//        map.put("productName", product.getProductName());
//        map.put("category", product.getCategory().toString());
//        map.put("imageUrl", product.getImageUrl());
//        map.put("price", product.getPrice());
//        map.put("stock", product.getStock());
//        map.put("description", product.getDescription());

        Date now =new Date();
        map.put("createdDate", now);
//        map.put("lastModifiedDate", now);

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
        map = mapSql(map, product);

        map.put("productId", productId);
//        map.put("productName", product.getProductName());
//        map.put("category", product.getCategory().toString());
//        map.put("imageUrl", product.getImageUrl());
//        map.put("price", product.getPrice());
//        map.put("stock", product.getStock());
//        map.put("description", product.getDescription());
//
//        Date now =new Date();
//        map.put("lastModifiedDate", now);

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

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id=:productId";
        Map<String, Integer> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {

        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date " +
                "FROM product WHERE TRUE";

        Map<String, Object> map = new HashMap<>();

        sql = addFilterSql(sql, map, productQueryParams);

        sql = sql + " ORDER BY "+productQueryParams.getOrderBy()
                + " "+ productQueryParams.getSort()
                +" LIMIT :limit OFFSET :offset ";

        map.put("limit",productQueryParams.getLimit());
        map.put("offset", productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        return productList;
    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {

        String sql = "SELECT COUNT(*) " +
                "FROM product WHERE TRUE";

        Map<String, Object> map = new HashMap<>();

        sql = addFilterSql(sql, map, productQueryParams);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
        return total;
    }

    private String addFilterSql(String sql, Map<String, Object> map, ProductQueryParams productQueryParams){

        if (productQueryParams.getCategory()!=null){
            sql += " AND category = :category";
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch()!= null){
            sql += " AND product_name LIKE :search";
            map.put("search", "%"+productQueryParams.getSearch()+"%");
        }

        return sql;
    }

    private Map<String, Object> mapSql(Map<String, Object> map, ProductRequest product){

        map.put("productName", product.getProductName());
        map.put("category", product.getCategory().toString());
        map.put("imageUrl", product.getImageUrl());
        map.put("price", product.getPrice());
        map.put("stock", product.getStock());
        map.put("description", product.getDescription());

        Date now =new Date();
        map.put("lastModifiedDate", now);

        return map;
    }

    @Override
    public void updateStock(Integer productId, Integer stock) {

        String sql = "UPDATE product " +
                "SET stock=:stock, last_modified_date=:lastModifiedDate " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();

        map.put("productId", productId);
        map.put("stock", stock);
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
