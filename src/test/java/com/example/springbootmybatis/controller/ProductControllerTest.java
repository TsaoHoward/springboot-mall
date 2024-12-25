//package com.example.springbootmybatis.controller;
//
//import com.example.springbootmybatis.entity.Product;
//import com.example.springbootmybatis.service.ProductService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//public class ProductControllerTest {
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @Test
//    public void testFindById_WithExistingId_ReturnsProduct() throws Exception {
//        Product product = new Product(1, "Test Product", "Category", "test.jpg", 100, 20, "Description");
//
//        when(productService.findById(1)).thenReturn(product);
//
//        mockMvc.perform(get("/products/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.productName", is("Test Product")))
//                .andExpect(jsonPath("$.category", is("Category")))
//                .andExpect(jsonPath("$.price", is(100)))
//                .andExpect(jsonPath("$.stock", is(20)));
//
//        verify(productService, times(1)).findById(1);
//    }
//
//    @Test
//    public void testFindById_WithNonExistingId_ReturnsNoContent() throws Exception {
//        when(productService.findById(999)).thenReturn(null);
//
//        mockMvc.perform(get("/products/999"))
//                .andExpect(status().isNoContent());
//
//        verify(productService, times(1)).findById(999);
//    }
//
//    @Test
//    public void testFindAll_ShouldReturnListOfProducts() throws Exception {
//        List<Product> products = Arrays.asList(
//                new Product(1, "Product1", "Category1", "url1.jpg", 10, 100, "Description1"),
//                new Product(2, "Product2", "Category2", "url2.jpg", 20, 200, "Description2")
//        );
//
//        when(productService.findAll(org.mockito.ArgumentMatchers.any(Product.class))).thenReturn(products);
//
//        mockMvc.perform(get("/products/"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].productName", is("Product1")))
//                .andExpect(jsonPath("$[1].productName", is("Product2")));
//
//        verify(productService, times(1)).findAll(org.mockito.ArgumentMatchers.any(Product.class));
//    }
//
//    @Test
//    public void testInsertProduct_ShouldReturnCreatedProduct() throws Exception {
//        Product product = new Product(null, "New Product", "Category", "image.jpg", 15, 50, "Description");
//        Product createdProduct = new Product(1, "New Product", "Category", "image.jpg", 15, 50, "Description");
//
//        when(productService.insertProduct(org.mockito.ArgumentMatchers.any(Product.class))).thenReturn(1);
//        when(productService.findById(1)).thenReturn(createdProduct);
//
//        mockMvc.perform(post("/products/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(product)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.productId", is(1)))
//                .andExpect(jsonPath("$.productName", is("New Product")));
//
//        verify(productService, times(1)).insertProduct(org.mockito.ArgumentMatchers.any(Product.class));
//        verify(productService, times(1)).findById(1);
//    }
//
//    @Test
//    public void testDeleteById_WithExistingId_ShouldReturnNoContent() throws Exception {
//        Product product = new Product(1, "Test Product", "Category", "test.jpg", 50, 10, "Description");
//
//        when(productService.findById(1)).thenReturn(product);
//        doNothing().when(productService).deleteById(1);
//
//        mockMvc.perform(delete("/products/1"))
//                .andExpect(status().isNoContent());
//
//        verify(productService, times(1)).findById(1);
//        verify(productService, times(1)).deleteById(1);
//    }
//
//    @Test
//    public void testDeleteById_WithNonExistingId_ShouldReturnNotFound() throws Exception {
//        when(productService.findById(999)).thenReturn(null);
//
//        mockMvc.perform(delete("/products/999"))
//                .andExpect(status().isNotFound());
//
//        verify(productService, times(1)).findById(999);
//    }
//
//    @Test
//    public void testUpdateById_WithExistingId_ShouldReturnOk() throws Exception {
//        Product existingProduct = new Product(1, "Existing Product", "Category", "image.jpg", 100, 10, "Description");
//        Product updatedProduct = new Product(1, "Updated Product", "Updated Category", "image.jpg", 150, 20, "Updated Description");
//
//        when(productService.findById(1)).thenReturn(existingProduct);
//        doNothing().when(productService).updateById(org.mockito.ArgumentMatchers.any(Product.class));
//
//        mockMvc.perform(put("/products/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedProduct)))
//                .andExpect(status().isOk());
//
//        verify(productService, times(1)).findById(1);
//        verify(productService, times(1)).updateById(org.mockito.ArgumentMatchers.any(Product.class));
//    }
//
//    @Test
//    public void testUpdateById_WithNonExistingId_ShouldReturnNotFound() throws Exception {
//        Product updatedProduct = new Product(999, "Updated Product", "Updated Category", "image.jpg", 150, 20, "Updated Description");
//
//        when(productService.findById(999)).thenReturn(null);
//
//        mockMvc.perform(put("/products/999")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(updatedProduct)))
//                .andExpect(status().isNotFound());
//
//        verify(productService, times(1)).findById(999);
//    }
//}