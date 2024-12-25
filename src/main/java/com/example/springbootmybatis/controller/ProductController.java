package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ProductDto;
//import com.example.springbootmybatis.po.ProductExample;
import com.example.springbootmybatis.service.ProductService;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){

        ProductDto productDto = new ProductDto();
        productDto.setProductId(productId);

        ProductDetailVo productDetailVo = productService.findProduct(productDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody @Validated ProductDto productDto){
        ProductDetailVo productDetailVo = productService.addProduct(productDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody @Validated ProductDto productDto){
        productDto.setProductId(productId);
        ProductDetailVo productDetailVo = productService.alterProduct(productDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(productId);
        ProductDetailVo productDetailVo = productService.deleteProductById(productDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<ProductListVo> findAll(@RequestBody @Validated PageResponseDto<?> pageRequest) {
        ProductListVo productListVo = productService.findAll(pageRequest);
        return ResponseEntity.ok(productListVo);
    }


}
