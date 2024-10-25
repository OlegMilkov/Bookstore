package com.example.bookstore.service;

import com.example.bookstore.entity.Order;
import com.example.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }



    @Override
    @Transactional
    public Order getOrderByID(int id){
        return orderRepository.getReferenceById(id);
    }


    @Override
    @Transactional
    public void saveOrder(Order order) {
        if (order.getOrderDate() == null) {
            // Если orderDate равно null, установите текущую дату
            order.setOrderDate(LocalDateTime.now());
        }
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

    @Override
    public List<List<Integer>> processBookOrders(List<Integer> bookIds, List<Integer> quantities) {
        List<Integer> bookIdNumber = new ArrayList<>();
        List<Integer> quantityNumber = new ArrayList<>();

        for (int i = 0; i < bookIds.size(); i++) {
            int bookId = bookIds.get(i);
            int quantity = quantities.get(i);

            bookIdNumber.add(bookId);
            quantityNumber.add(quantity);
        }

        return Arrays.asList(bookIdNumber, quantityNumber);
    }


}
