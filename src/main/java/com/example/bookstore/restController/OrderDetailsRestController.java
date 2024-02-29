package com.example.bookstore.restController;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //додати нове замовлення
    @PostMapping("/orderDetail")
    public OrderDetail addNewOrderDetail(@RequestBody OrderDetail orderDetail) {
        orderDetailsService.saveOrderDetail(orderDetail);
        return orderDetail;
    }



}
