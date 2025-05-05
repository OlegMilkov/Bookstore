package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Order;
import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.entity.ShoppingCart;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.OrderDetailsService;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/getAllBook")
    public String showAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "all-Books";
    }

    @GetMapping("/shoppingCart")
    public String ShoppingCart(Model model) {
        List<Book> booksInCart = shoppingCart.getBooks();
        model.addAttribute("booksInCart", booksInCart);
        return "shoppingCart";
    }



    @PostMapping("/addOrder")
    public String addOrder(@RequestParam("bookId") List<Integer> bookIds,
                           @RequestParam("quantity") List<Integer> quantities,
                           Model model) {

        List<List<Integer>> processedData = orderService.processBookOrders(bookIds, quantities);
        model.addAttribute("book", processedData.get(0));
        model.addAttribute("quantity", processedData.get(1));

        Order order = new Order();
        model.addAttribute("order", order);

        return "order-Info";
    }




    @PostMapping("/saveOrderAndOrderDetail")
    public String saveOrder(@ModelAttribute("order") Order order,
                            @RequestParam("bookId") List<Integer> bookIds,
                            @RequestParam("quantity") List<Integer> quantities,
                            Model model) {
        orderService.saveOrder(order);
        orderDetailsService.saveOrderAndDetails(order, bookIds, quantities);
        shoppingCart.clear();


        List<OrderDetail> orderDetailsWithIdOrder = orderDetailsService.getAllOrderDetailsByOrder(order.getId());
        model.addAttribute("orderDetailItem", orderDetailsWithIdOrder);

        return "/orderDetail-info";
    }


    @RequestMapping("/addBookToShoppingCart")
    public String addBookToCart(@RequestParam("bookId") int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            boolean isBookInCart = shoppingCart.getBooks().stream()
                    .anyMatch(cartBook -> cartBook.getId() == book.getId());

            if (!isBookInCart) {
                shoppingCart.addBook(book);
            } else {
                System.out.println("Книга уже есть в корзине");
            }
        }
        System.out.println(shoppingCart.getBooks());
        return "redirect:/book/getAllBook";
    }


    //    --------------------------------------------------------

    @RequestMapping("/removeBookFromShoppingCart")
    public String removeBookFromShoppingCart(@RequestParam("bookId") int bookId) {
        Book book = bookService.getBookById(bookId);
        shoppingCart.removeBook(book);
        System.out.println(shoppingCart.getBooks());

        return "redirect:/book/shoppingCart";
    }


    @GetMapping("/mainPage")
    public String mainPage() {
        return "redirect:/book/getAllBook";
    }


}
