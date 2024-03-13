package com.example.bookstore.dao;

import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;

public interface UserDao {

    public void saveUser(Users users);

    public void saveRoles(Roles roles);
}
