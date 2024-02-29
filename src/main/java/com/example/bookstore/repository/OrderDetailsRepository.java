package com.example.bookstore.repository;

import com.example.bookstore.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderDetailsRepository  extends JpaRepository<OrderDetail, Integer> {
}
