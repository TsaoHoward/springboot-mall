package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.ProductDto;
import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.po.Product;
import com.example.springbootmybatis.service.ProductService;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() {
        // 模擬服務層行為
        when(productService.findProduct(any(ProductDto.class))).thenReturn(mockProductDetailVo());

        // 執行測試
        ResponseEntity<?> response = productController.getProductById(1);

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, ((ProductDetailVo) response.getBody()).getProductId());

        // 驗證調用次數
        verify(productService, times(1)).findProduct(any(ProductDto.class));
    }

    @Test
    void testCreateProduct() {
        // 模擬服務層行為
        when(productService.addProduct(any(ProductDto.class))).thenReturn(mockProductDetailVo());

        // 執行測試
        ResponseEntity<?> response = productController.createProduct(new ProductDto());

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Product 1", ((ProductDetailVo) response.getBody()).getProductName());

        // 驗證調用次數
        verify(productService, times(1)).addProduct(any(ProductDto.class));
    }

    @Test
    void testFindAllProducts() {
        // 模擬服務層行為
        when(productService.findAll(any(PageResponseDto.class))).thenReturn(mockProductListVo());

        // 執行測試
        ResponseEntity<?> response = productController.findAll(new PageResponseDto<>());

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, ((ProductListVo) response.getBody()).getProducts().size());

        // 驗證調用次數
        verify(productService, times(1)).findAll(any(PageResponseDto.class));
    }

    private ProductDetailVo mockProductDetailVo() {
        ProductDetailVo productDetailVo = new ProductDetailVo();
        productDetailVo.setProductId(1);
        productDetailVo.setProductName("Product 1");
        return productDetailVo;
    }

    private ProductListVo mockProductListVo() {
        ProductListVo productListVo = new ProductListVo();
        productListVo.setProducts(List.of(mockProduct())); // 修改這裡，傳遞 Product 的實例
        return productListVo;
    }

    private Product mockProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Product 1");
        product.setPrice(100);
        product.setStock(50);
        product.setCategory("Category 1");
        return product;
    }

}
