package com.example.bookstore.service;


import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;



public interface UserService {

    public void saveUser(Users users);

    public void saveRoles(Roles roles);
}
