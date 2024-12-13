package com.howard.springbootmall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howard.springbootmall.constant.ProductCategory;
import com.howard.springbootmall.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getProductSuccess() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/{productId}", 1);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(jsonPath("$.productName", equalTo("蘋果（澳洲）")))
                .andExpect(jsonPath("$.category", equalTo("FOOD")))
                .andExpect(jsonPath("$.imageUrl", equalTo("https://cdn.pixabay.com/photo/2016/11/30/15/00/apples-1872997_1280.jpg")))
                .andExpect(jsonPath("$.price", equalTo("30")))
                .andExpect(jsonPath("$.stock", equalTo("10")))
                .andExpect(jsonPath("$.description", equalTo("這是來自澳洲的蘋果！")))
                .andExpect(jsonPath("$.createdDate", equalTo("2022-03-19 17:00:00")))
                .andExpect(jsonPath("$.lastModifiedDate", equalTo("2022-03-22 18:00:00")));
    }

    @Test
    @Transactional
    public void createProduct_success() throws Exception {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName("test food product");
        productRequest.setCategory(ProductCategory.FOOD);
        productRequest.setImageUrl("www.test.com");
        productRequest.setPrice(8080);
        productRequest.setStock(2222);

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.productName", equalTo("test food product")))
                .andExpect(jsonPath("$.category", equalTo("FOOD")))
                .andExpect(jsonPath("$.imageUrl", equalTo("www.test.com")))
                .andExpect(jsonPath("$.price", equalTo(8080)))
                .andExpect(jsonPath("$.stock", equalTo(2222)))
                .andExpect(jsonPath("$.description", nullValue()))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

    @Test
    @Transactional
    public void createProduct_illegalArgument() throws Exception {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName("test food product");

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    @Test
    @Transactional
    public void updateProduct_success() throws Exception {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductName("蘋果");
        productRequest.setCategory(ProductCategory.FOOD);
        productRequest.setImageUrl("https://cdn.pixabay.com/photo/2014/02/01/17/28/apple-256261__480.jpg");
        productRequest.setPrice(20);
        productRequest.setStock(10);

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.productName", equalTo("test food product")))
                .andExpect(jsonPath("$.category", equalTo("FOOD")))
                .andExpect(jsonPath("$.imageUrl", equalTo("www.test.com")))
                .andExpect(jsonPath("$.price", equalTo("8080")))
                .andExpect(jsonPath("$.stock", equalTo("2222")))
                .andExpect(jsonPath("$.description", nullValue()))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

}