//package com.example.springbootmybatis.controller;
//
//import com.example.springbootmybatis.dto.PageResponseDto_old;
//import com.example.springbootmybatis.entity.Product_old;
//import com.example.springbootmybatis.service.ProductService_old;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//@Validated
//public class ProductController_old {
//
//    @Autowired
//    private ProductService_old productService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product_old> findById(@PathVariable Integer id) {
//
//        Product_old productOld = productService.findById(id);
//        if (productOld == null) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//        return ResponseEntity.ok(productOld);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<PageResponseDto_old<Product_old>> findAll(
//            @RequestParam(required = false) String productName,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) Integer price,
//            @RequestParam(required = false) Integer stock,
//            @RequestParam(defaultValue = "10") int limit,  // 每页行数，默认值10
//            @RequestParam(defaultValue = "0") int offset  // 偏移量，默认值0
//    ) {
//        // 将查询条件和分页参数封装到 Product 对象中
//        Product_old productOld = new Product_old();
//        productOld.setProductName(productName);
//        productOld.setCategory(category);
//        productOld.setPrice(price);
//        productOld.setStock(stock);
//
//        int total = productService.count(productOld);  // 获取总记录数
//        List<Product_old> productOlds = productService.findAll(productOld, limit, offset);  // 获取分页数据
//
//        // 返回带分页信息的响应
//        PageResponseDto_old<Product_old> pageResponseDto = new PageResponseDto_old<>(total, limit, offset, productOlds);
//        return ResponseEntity.status(HttpStatus.OK).body(pageResponseDto);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<Product_old> insertProduct(@RequestBody Product_old productOld) {
//        Integer productId = productService.insertProduct(productOld);
//
//        Product_old newProductOld = productService.findById(productId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newProductOld);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
//        Product_old productOld = productService.findById(id);
//        if( productOld != null){
//            productService.deleteById(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Product_old productOld) {
//        Product_old currentProductOld = productService.findById(id);
//        if( currentProductOld != null){
//            productService.updateById(productOld);
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//}
