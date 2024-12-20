package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.PageResponseDto;
import com.example.springbootmybatis.dto.ResponseDto;
import com.example.springbootmybatis.mapper.ProductMapper;
import com.example.springbootmybatis.po.Product;
import com.example.springbootmybatis.po.ProductExample;
import com.example.springbootmybatis.vo.ProductDetailVo;
import com.example.springbootmybatis.vo.ProductListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product dtoToModel(ResponseDto responseDto){
        Product product = new Product();
//        BeanUtils.copyProperties(responseDto, product);
        if(responseDto.getProductId() != null){
            product.setProductId(responseDto.getProductId());
        }
        if(responseDto.getProductName() != null){
            product.setProductName(responseDto.getProductName());
        }
        if (responseDto.getPrice() != null) {
            product.setPrice(responseDto.getPrice());
        }
        if (responseDto.getStock() != null) {
            product.setStock(responseDto.getStock());
        }
        if (responseDto.getCategory() != null) {
            product.setCategory(responseDto.getCategory());
        }
        if (responseDto.getDescription() != null) {
            product.setDescription(responseDto.getDescription());
        }
        if (responseDto.getImageUrl() != null) {
            product.setImageUrl(responseDto.getImageUrl());
        }
        if (responseDto.getCreatedDate() != null) {
            product.setCreatedDate(responseDto.getCreatedDate());
        }
        if (responseDto.getLastModifiedDate() != null) {
            product.setLastModifiedDate(responseDto.getLastModifiedDate());
        }
        return product;
    }

    public ProductExample dtoToExample(PageResponseDto<ProductExample.Criteria> dto) {
        ProductExample example = new ProductExample();

        // 设置排序字段
        example.setOrderByClause(dto.getOrderBy());

        // 设置是否 distinct
        example.setDistinct(dto.isDistinct());

        // 添加查询条件
        if (dto.getCriteria() != null) {
            for (ProductExample.Criteria criteria : dto.getCriteria()) {
                example.or(criteria);
            }
        }

        return example;
    }

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
    public ProductDetailVo alterProduct(ResponseDto responseDto) {
        if(responseDto.getProductId() != null){
            productMapper.updateByPrimaryKeySelective(dtoToModel(responseDto));
            return modelToVo(productMapper.selectByPrimaryKey(responseDto.getProductId()));
        }
        return null;
    }

    @Override
    public ProductDetailVo deleteProductById(ResponseDto responseDto) {
        if(responseDto.getProductId() != null){
            productMapper.deleteByPrimaryKey(responseDto.getProductId());
            return modelToVo(productMapper.selectByPrimaryKey(responseDto.getProductId()));
        }
        return null;

    }

    @Override
    public ProductDetailVo addProduct(ResponseDto responseDto) {
        Product product = dtoToModel(responseDto);
        productMapper.insertSelective(product);
        return modelToVo(product);
    }

    @Override
    public ProductDetailVo findProduct(ResponseDto responseDto) {
        if(responseDto.getProductId() != null){
//            productMapper.selectByPrimaryKey(responseDto.getProductId());
            return modelToVo(productMapper.selectByPrimaryKey(responseDto.getProductId()));
        }
        return null;
    }

    @Override
    public ProductListVo findAll(PageResponseDto pageResponseDto) {
        ProductExample example = dtoToExample(pageResponseDto);
        List<Product> productsList = productMapper.selectByExample(example);
        ProductListVo productListVo = listToVo(productsList, productsList.size(), pageResponseDto.getOffset(), pageResponseDto.getLimit());
        productListVo.setProducts(productsList);
        return productListVo;
    }
}
