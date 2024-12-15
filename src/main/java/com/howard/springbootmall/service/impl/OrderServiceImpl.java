package com.howard.springbootmall.service.impl;

import com.howard.springbootmall.dao.OrderDao;
import com.howard.springbootmall.dao.ProductDao;
import com.howard.springbootmall.dao.UserDao;
import com.howard.springbootmall.dto.BuyItem;
import com.howard.springbootmall.dto.CreateOrderRequest;
import com.howard.springbootmall.model.Order;
import com.howard.springbootmall.model.OrderItem;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest){

        int totalAmount =0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem:createOrderRequest.getBuyItemList()){

            Product product = productDao.getProductById(buyItem.getProductId());
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
        return order;
    }
}
