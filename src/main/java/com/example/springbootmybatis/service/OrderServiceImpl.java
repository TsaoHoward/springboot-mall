package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.OrderItemDto;
import com.example.springbootmybatis.dto.OrderDto;
import com.example.springbootmybatis.mapper.*;
import com.example.springbootmybatis.po.*;
import com.example.springbootmybatis.vo.OrderListVo;
import com.example.springbootmybatis.vo.OrderVo;
import com.example.springbootmybatis.vo.ProductDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class OrderServiceImpl implements OrderService{
    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;

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

    public Order makeOrder(Integer userId, Integer totalAmount){
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, OrderDto orderDto){

        Optional<User> user = userMapper.selectByPrimaryKey(userId);

        //validate user
        if (user.isEmpty()){
            log.warn("user {} don't exist", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount =0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItemDto orderItemDto : orderDto.getBuyItemList()){

            //validate product, stock
            Optional<Product> product = productMapper.selectByPrimaryKey(orderItemDto.getProductId());

            if(product.isEmpty()){
                log.warn("product {} don't exist", orderItemDto.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.get().getStock() < orderItemDto.getQuantity()){
                log.warn("product {} not enough, {} left, but {} demanded", product.get().getProductName(), product.get().getStock(), orderItemDto.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }


            //update stock
//            ProductExample example = new ProductExample();
//            example.createCriteria().andProductIdEqualTo(product.get().getProductId());
//            product.get().setAmount(product.get().getAmount()-orderItemDto.getQuantity());
//
//            productMapper.updateByExampleSelective(product, example);

            Product updatedProduct = new Product();
            updatedProduct.setProductId(product.get().getProductId());
            updatedProduct.setStock(product.get().getStock()-orderItemDto.getQuantity());
            productMapper.updateByPrimaryKeySelective(updatedProduct);

            //cal totalPrice
            int amount = product.get().getPrice() * orderItemDto.getQuantity();
            totalAmount += amount;


            //add orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.get().getProductId());
            orderItem.setAmount(amount);
            orderItem.setQuantity(orderItemDto.getQuantity());

            orderItemList.add(orderItem);
        }

        Integer orderId = orderMapper.insert(makeOrder(userId, totalAmount));

        for (OrderItem i : orderItemList){
            i.setOrderId(orderId);
            orderItemMapper.insert(i);
        }

        return orderId;
    }

    @Override
    public OrderVo getOrderById(Integer orderId) {

        Optional<Order> order = orderMapper.selectByPrimaryKey(orderId);
        if (order.isEmpty()){
            log.warn("order {} don't exist", orderId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<OrderItem> orderItemList = orderItemMapper.select(c->c.where(OrderItemDynamicSqlSupport.orderId, isEqualTo(orderId)));
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderItemList(orderItemList);
        orderVo.setTotalAmount(order.get().getTotalAmount());
        orderVo.setOrderId(orderId);
        orderVo.setUserId(order.get().getUserId());
        return orderVo;
    }

    @Override
    public Long count(OrderDto orderDto) {
        return orderMapper.count(c->c.where(OrderDynamicSqlSupport.userId, isEqualTo(orderDto.getUserId())));
    }

    @Override
    public OrderListVo getOrders(OrderDto orderDto) {
        List<Order> orderList = orderMapper.select(c->c.where(
                OrderDynamicSqlSupport.userId,
                isEqualTo(orderDto.getUserId())));

        OrderListVo orderListVo = new OrderListVo();
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orderList){
            List<OrderItem> orderItemList = orderItemMapper.select(c->c.where(OrderItemDynamicSqlSupport.orderId, isEqualTo(order.getOrderId())));
            List<ProductDetailVo> productList = new ArrayList<>();
            for (OrderItem orderItem : orderItemList){

                ProductDetailVo productDetailVo = new ProductDetailVo();
                Optional<Product> product =productMapper.selectByPrimaryKey(orderItem.getProductId());
                BeanUtils.copyProperties(product,productDetailVo);
                productDetailVo.setStock(orderItem.getAmount());
                productList.add(productDetailVo);
            }

            OrderVo orderVo = new OrderVo();
            orderVo.setOrderItemList(productList);
            orderVo.setTotalAmount(order.getTotalAmount());
            orderVoList.add(orderVo);
        }
        orderListVo.setOrderList(orderVoList);
        return orderListVo;
    }
}
