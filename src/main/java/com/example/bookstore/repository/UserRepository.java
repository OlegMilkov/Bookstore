package com.example.bookstore.repository;

import com.example.bookstore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, String> {
        Optional<Users> findByUsername(String username); // Додайте цей метод

    }
