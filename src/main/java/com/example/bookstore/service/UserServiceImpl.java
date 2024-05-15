package com.example.bookstore.service;

import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import com.example.bookstore.repository.RolesRepository;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional
    public void saveUser(Users users){
        userRepository.save(users);
    }

    @Override
    @Transactional
    public void saveRoles(Roles roles) {
        rolesRepository.save(roles);
    }
}
