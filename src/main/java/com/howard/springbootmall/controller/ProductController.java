package com.howard.springbootmall.controller;

import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Validated ProductRequest productRequest){

        Integer productId = productService.createProduct(productRequest);
        Product newProduct = productService.getProductById(productId);

        if (productId != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Validated ProductRequest productRequest){

        Product productCheck = productService.getProductById(productId);
        if (productCheck == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Integer returnId = productService.updateProduct(productId, productRequest);
        Product newProduct = productService.getProductById(returnId);

        if (productId != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
