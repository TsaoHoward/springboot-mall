//package com.example.springbootmybatis.service;
//
//import com.example.springbootmybatis.entity.Product;
//import com.example.springbootmybatis.mapper.ProductMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ProductServiceImpl_old implements ProductService_old {
//
//    @Autowired
//    private ProductMapper productMapper;
//
//    private final static Logger log = LoggerFactory.getLogger(ProductService_old.class);
//
//    @Override
//    public Product findById(Integer id){
//        return productMapper.findById(id);
//    }
//
//    @Override
//    public Integer count(Product product){
//        return productMapper.count(product);
//    }
//
//    @Override
//    public List<Product> findAll(Product product, Integer limit, Integer offset){
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("productName", product.getProductName());
//        paramMap.put("category", product.getCategory());
//        paramMap.put("price", product.getPrice());
//        paramMap.put("stock", product.getStock());
//        paramMap.put("limit", limit);
//        paramMap.put("offset", offset);
//
//        return productMapper.findAll(paramMap);
//    }
//
//    @Override
//    @Transactional
//    public Integer insertProduct(Product product){
//        log.warn("Preparing to insert product: " + product.getProductName());
//        productMapper.insertProduct(product);
//        Integer generatedId = productMapper.selectLastInsertId();
//        log.warn("Generated Product ID: " + generatedId);
//        return generatedId;
//    }
//
//    @Override
//    public Product findByName(String name){
//        return productMapper.findByName(name);
//    }
//
//    @Override
//    public Integer selectLastInsertId(){
//        return productMapper.selectLastInsertId();
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        productMapper.deleteById(id);
//    }
//
//    @Override
//    public void updateById(Product product) {
//        productMapper.updateById(product);
//    }
//
//    @Override
//    public void updateStockById(Product product) {
//        productMapper.updateStockById(product);
//    }
//}
