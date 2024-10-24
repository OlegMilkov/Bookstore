package com.example.bookstore.configuration;

import com.example.bookstore.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Users user;

    public CustomUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles() != null ?
                List.of(() -> user.getRoles().getRoleName()) :
                Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Встановіть цю логіку відповідно до ваших вимог
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Встановіть цю логіку відповідно до ваших вимог
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Встановіть цю логіку відповідно до ваших вимог
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled(); // Використовуйте ваше поле isEnabled
    }

    public Users getUser() {
        return user;
    }
}
