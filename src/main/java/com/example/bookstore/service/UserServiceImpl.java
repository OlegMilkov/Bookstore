package com.example.bookstore.service;

import com.example.bookstore.configuration.CustomUserDetails;
import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import com.example.bookstore.repository.RolesRepository;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{

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



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return new CustomUserDetails(optionalUser.get());
        } else {
            throw new UsernameNotFoundException("Користувача з логіном " + username + " не знайдено.");
        }
    }
}
