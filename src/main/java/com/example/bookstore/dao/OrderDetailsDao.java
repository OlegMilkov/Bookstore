package com.example.bookstore.dao;

import com.example.bookstore.entity.OrderDetail;

import java.util.List;

public interface OrderDetailsDao {

    public List<OrderDetail> getAllOrderDetails();

public void saveOrderDetail(OrderDetail orderDetail);
}
