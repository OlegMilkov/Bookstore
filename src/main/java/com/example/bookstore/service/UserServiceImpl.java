package com.example.bookstore.service;

import com.example.bookstore.dao.UserDao;
import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void saveUser(Users users){
        userDao.saveUser(users);
    }

    @Override
    @Transactional
    public void saveRoles(Roles roles) {
        userDao.saveRoles(roles);
    }
}
