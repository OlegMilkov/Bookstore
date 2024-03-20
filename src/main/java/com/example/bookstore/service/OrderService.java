package com.example.bookstore.service;

import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();

    public  Order getOrderByID(int id);

    public void saveOrder(Order order);

    public void deleteOrder(int id);


}
