package com.example.bookstore.service;

import com.example.bookstore.dao.OrderDetailsDao;
import com.example.bookstore.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Override
    @Transactional
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailsDao.getAllOrderDetails();
    }
}
