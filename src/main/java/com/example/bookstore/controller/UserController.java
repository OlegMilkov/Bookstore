package com.example.bookstore.controller;

import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/signup")
    public String signup(Model model) {
        Users users= new Users();
        model.addAttribute("users", users);
        return "signup";
    }


    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") Users users){
        //отримання ролі та надання йому автоматично значення 2 (ROLE_CUSTOMER)
        Roles roles= new Roles();
        roles.setId(2);
        users.setRoles(roles);
//перетворення звичайного паролю в зашифравний
        String rawPassword = users.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        users.setPassword(encodedPassword);

        users.setEnabled(true);
        userService.saveUser(users);


        return"redirect:/book/getAllBook";
    }

}
