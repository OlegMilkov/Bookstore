package com.example.bookstore.restController;

import com.example.bookstore.entity.Order;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    //показати всі замовлення
    @GetMapping("/allOrders")
    public List<Order> showAllOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    //замовлення по id
    @GetMapping("/orderById/{id}")
    public Order showOrderByID(@PathVariable int id) {
        Order orderByID = orderService.getOrderByID(id);
        return orderByID;
    }

    //добавити нове замовдення
    @PostMapping("/order")
    public Order addNewOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return order;
    }

    //оновити замовлення
    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return order;
    }

    //видалення замовлення
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        Order order= orderService.getOrderByID(id);
        orderService.deleteOrder(id);
        return "Order with ID =" + id + " was deleted";
    }


}
