package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ProductDto;
import com.example.springbootmybatis.mapper.ProductMapper;
import com.example.springbootmybatis.po.Product;
//import com.example.springbootmybatis.po.ProductExample;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    public Product dtoToModel(ProductDto productDto){
        Product product = new Product();
//        BeanUtils.copyProperties(productDto, product);
        if(productDto.getProductId() != null){
            product.setProductId(productDto.getProductId());
        }
        if(productDto.getProductName() != null){
            product.setProductName(productDto.getProductName());
        }
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getStock() != null) {
            product.setStock(productDto.getStock());
        }
        if (productDto.getCategory() != null) {
            product.setCategory(productDto.getCategory());
        }
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getImageUrl() != null) {
            product.setImageUrl(productDto.getImageUrl());
        }
        if (productDto.getCreatedDate() != null) {
            product.setCreatedDate(productDto.getCreatedDate());
        }
        if (productDto.getLastModifiedDate() != null) {
            product.setLastModifiedDate(productDto.getLastModifiedDate());
        }
        return product;
    }

//    public ProductExample dtoToExample(PageResponseDto<ProductExample.Criteria> dto) {
//        ProductExample example = new ProductExample();
//
//        // 设置排序字段
//        example.setOrderByClause(dto.getOrderBy());
//
//        // 设置是否 distinct
//        example.setDistinct(dto.isDistinct());
//
//        // 添加查询条件
//        if (dto.getCriteria() != null) {
//            for (ProductExample.Criteria criteria : dto.getCriteria()) {
//                example.or(criteria);
//            }
//        }
//
//        return example;
//    }

    public ProductDetailVo modelToVo(Product product){
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        return productDetailVo;
    }

    public ProductListVo listToVo(List<Product> products, int total, int page, int limit){
        ProductListVo productListVo = new ProductListVo();
        productListVo.setProducts(products);
        productListVo.setTotal(total);
        productListVo.setPage(page);
        productListVo.setLimit(limit);
        return productListVo;
    }

    @Override
    public ProductDetailVo alterProduct(ProductDto productDto) {
        if(productDto.getProductId() != null){
            productMapper.updateByPrimaryKeySelective(dtoToModel(productDto));
//            return modelToVo(productMapper.selectByPrimaryKey(productDto.getProductId()));
            Optional<Product> product = productMapper.selectByPrimaryKey(productDto.getProductId());
            return modelToVo(product.get());
        }
        return null;
    }

    @Override
    public ProductDetailVo deleteProductById(ProductDto productDto) {
        if(productDto.getProductId() != null){
            productMapper.deleteByPrimaryKey(productDto.getProductId());
            return modelToVo(productMapper.selectByPrimaryKey(productDto.getProductId()).get());
        }
        return null;

    }

    @Override
    public ProductDetailVo addProduct(ProductDto productDto) {
        Product product = dtoToModel(productDto);
        productMapper.insertSelective(product);
        return modelToVo(product);
    }

    @Override
    public ProductDetailVo findProduct(ProductDto productDto) {
        if(productDto.getProductId() != null){
//            productMapper.selectByPrimaryKey(productDto.getProductId());
            return modelToVo(productMapper.selectByPrimaryKey(productDto.getProductId()).get());
        }
        return null;
    }

    @Override
    public ProductListVo findAll(PageResponseDto pageResponseDto) {
//        ProductExample example = dtoToExample(pageResponseDto);
//        List<Product> productsList = productMapper.selectByExample(example);
//        ProductListVo productListVo = listToVo(productsList, productsList.size(), pageResponseDto.getOffset(), pageResponseDto.getLimit());
//        productListVo.setProducts(productsList);
//        return productListVo;

        List<Product> productsList = productMapper.select(c->c);
        ProductListVo productListVo = listToVo(productsList, productsList.size(), pageResponseDto.getOffset(), pageResponseDto.getLimit());
        productListVo.setProducts(productsList);
        return productListVo;
    }
}
