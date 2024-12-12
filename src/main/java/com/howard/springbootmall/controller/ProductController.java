package com.howard.springbootmall.controller;

import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer product_id){

        Product product = productService.getProductById(product_id);

        if (product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
