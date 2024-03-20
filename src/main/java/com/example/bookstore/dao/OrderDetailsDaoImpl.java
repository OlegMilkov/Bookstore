package com.example.bookstore.dao;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Autowired
   private OrderDetailsRepository orderDetailsRepository;

        @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailsRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getAllOrderDetailsByOrder(int id) {
        return orderDetailsRepository.findAllByOrderId(id);
    }


}
