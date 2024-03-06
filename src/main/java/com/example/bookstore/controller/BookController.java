package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.OrderDetailsService;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("/getAllBook")
    public String showAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "all-Books";
    }

    //----------------------------------------------------
    @RequestMapping("/addOrder")
    public String newOrder(@RequestParam("bookId") int bookId,
                           @RequestParam("quantity") int quantity,
                           Model model) {

        Book book = bookService.getBookById(bookId);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(quantity);
        orderDetail.setBook(book);
        orderDetailsService.saveOrderDetail(orderDetail);
        model.addAttribute("orderDetail", orderDetail);

        Order order = new Order();
        model.addAttribute("order", order);

        return "order-Info";
    }

    //---------------------------------------------------------
    @RequestMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order,
                            @ModelAttribute("orderDetail") OrderDetail orderDetail){
        orderService.saveOrder(order);

        orderDetail.setOrder(order);
        orderDetailsService.saveOrderDetail(orderDetail);

        return "redirect:/book/getAllBook";
    }
}

