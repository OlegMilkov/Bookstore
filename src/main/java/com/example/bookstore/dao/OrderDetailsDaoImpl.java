package com.example.bookstore.dao;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

        @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailsRepository.save(orderDetail);
    }


}
