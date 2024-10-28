package com.example.bookstore.service;

import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
public interface OrderDetailsService {

    public List<OrderDetail> getAllOrderDetails();

    public void saveOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> getAllOrderDetailsByOrder(int id);

    public void saveOrderAndDetails(Order order, List<Integer> bookIds, List<Integer> quantities);

}
