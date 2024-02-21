package com.example.bookstore.repository;

import com.example.bookstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetail, Integer> {
}
