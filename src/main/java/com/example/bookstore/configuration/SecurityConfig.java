package com.example.bookstore.configuration;

import com.example.bookstore.service.CustomUserDetailsService;
import com.example.bookstore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
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
    private CustomUserDetailsService customUserDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
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
                                .requestMatchers("/user/**").permitAll()
                                .requestMatchers("/book/**").authenticated()
                )

                .formLogin(formLogin -> formLogin
                        .loginPage("/user/signin").permitAll()
                        .defaultSuccessUrl("/book/getAllBook", true)
                        .failureHandler((request, response, exception) -> {

                            String errorParam = exception instanceof BadCredentialsException ? "bad_credentials" : "unknown";
                            response.sendRedirect("/user/signin?error=" + errorParam);
                        })
                        .permitAll()
                )
                .build();
    }

}
