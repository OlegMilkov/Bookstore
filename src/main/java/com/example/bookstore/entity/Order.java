package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;


}
