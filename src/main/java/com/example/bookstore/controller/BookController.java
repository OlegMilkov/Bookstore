package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

@Autowired
private BookService bookService;

@RequestMapping("/getAllBook")
    public String showAllBooks(Model model){
        List<Book> allBooks=bookService.getAllBooks();
        model.addAttribute("allBooks",allBooks);
        return "all-Books";

    }

}
