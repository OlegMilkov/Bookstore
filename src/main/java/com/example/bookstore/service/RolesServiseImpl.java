package com.example.bookstore.service;

import com.example.bookstore.entity.Roles;
import com.example.bookstore.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiseImpl implements RolesServise {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles getRoleByName(String roleName) {
        return rolesRepository.findByRoleName(roleName);
    }
}
