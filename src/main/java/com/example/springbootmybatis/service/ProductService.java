package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ProductDto;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;

public interface ProductService {
//    ProductListVo findAll(PageResponseDto<Product> pageResponseDto);

    ProductDetailVo alterProduct(ProductDto productDto);
    ProductDetailVo deleteProductById(ProductDto productDto);
    ProductDetailVo addProduct(ProductDto productDto);
    ProductDetailVo findProduct(ProductDto productDto);

    ProductListVo findAll(PageResponseDto pageResponseDto);
}
