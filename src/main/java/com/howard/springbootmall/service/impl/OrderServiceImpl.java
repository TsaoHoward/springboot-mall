package com.howard.springbootmall.service.impl;

import com.howard.springbootmall.dao.OrderDao;
import com.howard.springbootmall.dao.ProductDao;
import com.howard.springbootmall.dao.UserDao;
import com.howard.springbootmall.dto.BuyItem;
import com.howard.springbootmall.dto.CreateOrderRequest;
import com.howard.springbootmall.model.Order;
import com.howard.springbootmall.model.OrderItem;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.model.User;
import com.howard.springbootmall.service.OrderService;
import com.howard.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest){

        User user =userDao.getUserById(userId);

        if (user == null){
            log.warn("user {} don't exist", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount =0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem:createOrderRequest.getBuyItemList()){

            Product product = productDao.getProductById(buyItem.getProductId());

            if(product == null){
                log.warn("product {} don't exist",buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()){
                log.warn("product {} not enough, {} left, but {} demanded",product.getProductName(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            productDao.updateStock(product.getProductId(), product.getStock()- buyItem.getQuantity());



            int amount = product.getPrice() * buyItem.getQuantity();
            totalAmount += amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getProductId());
            orderItem.setAmount(amount);
            orderItem.setQuantity(buyItem.getQuantity());

            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItem(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemById(orderId);
        order.setOrderItemList(orderItemList);
        return order;
    }
}
