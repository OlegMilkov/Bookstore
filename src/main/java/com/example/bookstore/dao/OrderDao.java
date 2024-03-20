package com.example.bookstore.dao;

import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderDao {

    public List<Order> getAllOrders();

    public Order getOrderByID(int id);

    public void saveOrder(Order order);

    public void deleteOrder(int id);


}
