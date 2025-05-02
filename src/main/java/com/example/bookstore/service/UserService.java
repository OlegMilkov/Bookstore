package com.example.bookstore.service;


import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface UserService {

    public void saveUser(Users users);

    public void saveRoles(Roles roles);

    public List<Users> getUsers();

    public Users getUserById( int Id);
}
