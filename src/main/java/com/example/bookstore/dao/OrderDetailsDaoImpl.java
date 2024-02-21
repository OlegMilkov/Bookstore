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
//        Query query = entityManager.createQuery("from OrderDetail ");
//        List<OrderDetail> allOrderDetails = query.getResultList();
//        return allOrderDetails;

        return  orderDetailsRepository.findAll();
    }


}
