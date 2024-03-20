package com.example.bookstore.service;

import com.example.bookstore.dao.OrderDao;
import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }



    @Override
    @Transactional
    public Order getOrderByID(int id){
        return orderDao.getOrderByID(id);
    }


    @Override
    @Transactional
    public void saveOrder(Order order) {
        if (order.getOrderDate() == null) {
            // Если orderDate равно null, установите текущую дату
            order.setOrderDate(LocalDateTime.now());
        }
        orderDao.saveOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id){
        orderDao.deleteOrder(id);
    }


}
