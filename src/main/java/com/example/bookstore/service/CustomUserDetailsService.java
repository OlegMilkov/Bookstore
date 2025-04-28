package com.example.bookstore.service;

import com.example.bookstore.configuration.CustomUserDetails;
import com.example.bookstore.entity.Users;
import com.example.bookstore.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
