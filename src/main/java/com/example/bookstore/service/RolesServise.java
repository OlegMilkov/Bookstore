package com.example.bookstore.service;

import com.example.bookstore.entity.Roles;
import org.springframework.stereotype.Service;

public interface RolesServise {

    public Roles getRoleByName(String roleName);
}
