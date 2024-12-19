package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.entity.Product;
import com.example.springbootmybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {

        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/")
    public ResponseEntity<PageResponseDto<Product>> findAll(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer stock,
            @RequestParam(defaultValue = "10") int limit,  // 每页行数，默认值10
            @RequestParam(defaultValue = "0") int offset  // 偏移量，默认值0
    ) {
        // 将查询条件和分页参数封装到 Product 对象中
        Product product = new Product();
        product.setProductName(productName);
        product.setCategory(category);
        product.setPrice(price);
        product.setStock(stock);

        int total = productService.count(product);  // 获取总记录数
        List<Product> products = productService.findAll(product, limit, offset);  // 获取分页数据

        // 返回带分页信息的响应
        PageResponseDto<Product> pageResponseDto = new PageResponseDto<>(total, limit, offset, products);
        return ResponseEntity.status(HttpStatus.OK).body(pageResponseDto);
    }

    @PostMapping("/")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        Integer productId = productService.insertProduct(product);

        Product newProduct = productService.findById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if( product != null){
            productService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Product product) {
        Product currentProduct = productService.findById(id);
        if( currentProduct != null){
            productService.updateById(product);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
