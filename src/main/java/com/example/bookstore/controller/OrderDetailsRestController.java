package com.example.bookstore.controller;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsRestController {

    @Autowired
    public OrderDetailsService orderDetailsService;

    //показати всі деталі замовлення
    @GetMapping("/allOrderDetails")
    public List<OrderDetail> showAllOrderDetails() {
        List<OrderDetail> allOrderDetails = orderDetailsService.getAllOrderDetails();
        return allOrderDetails;
    }


}
