package com.example.bookstore.dao;

import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import com.example.bookstore.repository.RolesRepository;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void saveUser(Users users){
        userRepository.save(users);
    }


@Override
public void saveRoles(Roles roles){
    rolesRepository.save(roles);
}
}
