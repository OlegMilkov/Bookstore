package com.example.bookstore.controller;

import com.example.bookstore.entity.User;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user= new User();
        model.addAttribute("user", user);
        return "signup";
    }


    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return"redirect:/book/getAllBook";
    }

}
