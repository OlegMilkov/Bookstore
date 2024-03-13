package com.example.bookstore.repository;

import com.example.bookstore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface UserRepository extends JpaRepository<Users, String> {

    }
