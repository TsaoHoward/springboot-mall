package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.po.OrderItem;
import com.example.springbootmybatis.po.OrderItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderItemMapper {
    long countByExample(OrderItemExample example);

    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Integer orderItemId);

    int insert(OrderItem row);

    int insertSelective(OrderItem row);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByExampleSelective(@Param("row") OrderItem row, @Param("example") OrderItemExample example);

    int updateByExample(@Param("row") OrderItem row, @Param("example") OrderItemExample example);

    int updateByPrimaryKeySelective(OrderItem row);

    int updateByPrimaryKey(OrderItem row);
}