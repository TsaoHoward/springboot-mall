package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ResponseDto;
import com.example.springbootmybatis.po.Product;
import com.example.springbootmybatis.po.ProductExample;
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

        ResponseDto responseDto = new ResponseDto();
        responseDto.setProductId(productId);

        ProductDetailVo productDetailVo = productService.findProduct(responseDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody @Validated ResponseDto responseDto){
        ProductDetailVo productDetailVo = productService.addProduct(responseDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody @Validated ResponseDto responseDto){
        responseDto.setProductId(productId);
        ProductDetailVo productDetailVo = productService.alterProduct(responseDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setProductId(productId);
        ProductDetailVo productDetailVo = productService.deleteProductById(responseDto);
        if(productDetailVo != null){
            return ResponseEntity.ok(productDetailVo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<ProductListVo> findAll(@RequestBody @Validated PageResponseDto<ProductExample.Criteria> pageRequest) {
        ProductListVo productListVo = productService.findAll(pageRequest);
        return ResponseEntity.ok(productListVo);
    }


}
