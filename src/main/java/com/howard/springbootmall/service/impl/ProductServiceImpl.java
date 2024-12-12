package com.howard.springbootmall.service.impl;

import com.howard.springbootmall.dao.ProductDao;
import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest product) {

        return productDao.createProduct(product);
    }

    @Override
    public Integer updateProduct(Integer productId, ProductRequest product) {
        return productDao.updateProduct(productId, product);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = productDao.getProducts();
        return productList;
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
