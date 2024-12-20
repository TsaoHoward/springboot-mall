package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ResponseDto;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;

public interface ProductService {
//    ProductListVo findAll(PageResponseDto<Product> pageResponseDto);

    ProductDetailVo alterProduct(ResponseDto responseDto);
    ProductDetailVo deleteProductById(ResponseDto responseDto);
    ProductDetailVo addProduct(ResponseDto responseDto);
    ProductDetailVo findProduct(ResponseDto responseDto);

    ProductListVo findAll(PageResponseDto pageResponseDto);
}
