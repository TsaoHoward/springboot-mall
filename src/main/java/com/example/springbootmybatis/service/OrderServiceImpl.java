//package com.example.springbootmybatis.service;
//
//import com.example.springbootmybatis.dto.OrderItemDto;
//import com.example.springbootmybatis.dto.OrderListDto;
//import com.example.springbootmybatis.dto.OrderQueryParams;
//import com.example.springbootmybatis.dto.PageResponseDto;
//import com.example.springbootmybatis.mapper.OrderItemMapper;
//import com.example.springbootmybatis.mapper.OrderMapper;
//import com.example.springbootmybatis.mapper.ProductMapper;
//import com.example.springbootmybatis.mapper.UserMapper;
//import com.example.springbootmybatis.po.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderServiceImpl implements OrderService{
//    private final static Logger log = LoggerFactory.getLogger(UserService.class);
//
//    @Autowired
//    private OrderMapper orderMapper;
//    @Autowired
//    private OrderItemMapper orderItemMapper;
//    @Autowired
//    private ProductMapper productMapper;
//    @Autowired
//    private UserMapper userMapper;
//
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
//
//    public Order makeOrder(Integer userId, Integer totalAmount){
//        Order order = new Order();
//        order.setUserId(userId);
//        order.setTotalAmount(totalAmount);
//        return order;
//    }
//
//    @Transactional
//    @Override
//    public Integer createOrder(Integer userId, OrderListDto orderListDto){
//
//        User user = userMapper.selectByPrimaryKey(userId);
//
//        //validate user
//        if (user == null){
//            log.warn("user {} don't exist", userId);
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//
//        int totalAmount =0;
//        List<OrderItem> orderItemList = new ArrayList<>();
//
//        for (OrderItemDto orderItemDto : orderListDto.getBuyItemList()){
//
//            //validate product, stock
//            Product product = productMapper.selectByPrimaryKey(orderItemDto.getProductId());
//
//            if(product == null){
//                log.warn("product {} don't exist", orderItemDto.getProductId());
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//            } else if (product.getStock() < orderItemDto.getQuantity()){
//                log.warn("product {} not enough, {} left, but {} demanded",product.getProductName(), product.getStock(), orderItemDto.getQuantity());
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//            }
//
//
//            //update stock
//            ProductExample example = new ProductExample();
//            example.createCriteria().andProductIdEqualTo(product.getProductId());
//            product.setStock(product.getStock()-orderItemDto.getQuantity());
//
//            productMapper.updateByExampleSelective(product, example);
//
//            //cal totalPrice
//            int amount = product.getPrice() * orderItemDto.getQuantity();
//            totalAmount += amount;
//
//
//            //add orderItem
//            OrderItem orderItem = new OrderItem();
//            orderItem.setProductId(product.getProductId());
//            orderItem.setAmount(amount);
//            orderItem.setQuantity(orderItemDto.getQuantity());
//
//            orderItemList.add(orderItem);
//        }
//
//        Integer orderId = orderMapper.insert(makeOrder(userId, totalAmount));
//
//        for (OrderItem i : orderItemList){
//            i.setOrderId(orderId);
//            orderItemMapper.insert(i);
//        }
//
//        return orderId;
//    }
//
//    @Override
//    public Order getOrderById(Integer orderId) {
//
//        Order order = orderMapper.selectByPrimaryKey(orderId);
//
//        List<OrderItem> orderItemList = orderItemMapper.selectByPrimaryKey(orderId);
//        order.setOrderItemList(orderItemList);
//        return order;
//    }
//
//    @Override
//    public Integer countOrders(OrderQueryParams orderQueryParams) {
//        return OrderMapper.countOrders(orderQueryParams);
//    }
//
//    @Override
//    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
//        List<Order> orderList = OrderMapper.getOrders(orderQueryParams);
//
//        for (Order order : orderList){
//            List<OrderItem> orderItemList = OrderMapper.getOrderItemByOrderId(order.getOrderId());
//            order.setOrderItemList(orderItemList);
//        }
//        return orderList;
//}
