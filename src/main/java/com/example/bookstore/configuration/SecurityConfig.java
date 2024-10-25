package com.example.bookstore.configuration;

import com.example.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserServiceImpl userService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/updateInfo").hasRole("MANAGER")
//                        .requestMatchers("/deleteChild").hasRole("MANAGER")
//                        .requestMatchers("/addNewChild").hasAnyRole("MANAGER", "HR")
                                .requestMatchers("/user/**").permitAll()
                                .requestMatchers("/book/**").authenticated()
//                                .requestMatchers("/book/shoppingCart").permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/user/signin")  // вказуємо шлях до власної сторінки логіну
                        .permitAll()  // дозволяємо доступ до сторінки логіну всім
                        // перенаправлення на головну сторінку після успішної аутентифікації
                        .defaultSuccessUrl("/book/getAllBook", true)
                )
                .build();
    }

}
