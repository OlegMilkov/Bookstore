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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.ext.Locator2;

import java.util.ArrayList;
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

    @RequestMapping("/getAllBook")
    public String showAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "all-Books";
    }


    //--------------------------------------------------------
    @RequestMapping("/addBookToShoppingCart")
    public String addBookToCart(@RequestParam("bookId") int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            shoppingCart.addBook(book);
        }
//що це таке
        System.out.println(shoppingCart.getBooks());
        return "redirect:/book/getAllBook";
    }

    //    --------------------------------------------------------
    @RequestMapping("/shoppingCart")
    public String ShoppingCart(Model model) {
        List<Book> booksInCart = shoppingCart.getBooks();
        model.addAttribute("booksInCart", booksInCart);

        return "shoppingCart";
    }


    @RequestMapping("/addOrder11")
    public String addOrder(@RequestParam("bookId") List<Integer> bookIds,
                           @RequestParam("quantity") List<Integer> quantities,
                           Model model) {

        List<Integer> bookIdNumber= new ArrayList<>();
        List<Integer> quantityNumber= new ArrayList<>();

        // Логіка обробки замовлення для кожної книжки в списку
        for (int i = 0; i < bookIds.size(); i++) {
            int bookId = bookIds.get(i);
            int quantity = quantities.get(i);

            bookIdNumber.add(bookId);
            quantityNumber.add(quantity);
        }
        model.addAttribute("book", bookIdNumber);
       model.addAttribute("quantity", quantityNumber);

        // Додаємо порожній об'єкт Order в модель
        Order order = new Order();
        model.addAttribute("order", order);

        return "order-Info2";
    }

    //---------------------------------------------------------
    @RequestMapping("/saveOrderAndOrderDetail11")
    public String saveOrder11(@ModelAttribute("order") Order order,
                              @RequestParam("bookId") List<Integer> bookIds,
                              @RequestParam("quantity") List<Integer> quantities,
                            Model model) {

        orderService.saveOrder(order);
        int orderId =order.getId();

                for (int i = 0; i < bookIds.size(); i++) {
            int idNumber = bookIds.get(i);
            int quantityNumber = quantities.get(i);

            Book book= bookService.getBookById(idNumber);

            OrderDetail orderDetail= new OrderDetail();
            orderDetail.setQuantity(quantityNumber);
            orderDetail.setOrder(order);
            orderDetail.setBook(book);
            orderDetailsService.saveOrderDetail(orderDetail); // Зберігаємо кожен orderDetail
        }

        List<OrderDetail> orderDetailsWithIdOrder=orderDetailsService.getAllOrderDetailsByOrder(orderId);
        model.addAttribute("orderDetailItem", orderDetailsWithIdOrder);


        return "/orderDetail-info";
    }

    //---------------------------------------------------------
    @RequestMapping("/saveOrderAndOrderDetail")
    public String saveOrder(@ModelAttribute("order") Order order,
                            @RequestParam("bookId") int bookId,
                            @RequestParam("quantity") int quantity,
                            Model model) {

        orderService.saveOrder(order);

        Book book = bookService.getBookById(bookId);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(quantity);
        orderDetail.setBook(book);
        orderDetail.setOrder(order);
        orderDetailsService.saveOrderDetail(orderDetail);

        model.addAttribute("orderDetail", orderDetail);


        return "/orderDetail-info";
    }

    @RequestMapping("/addOrder")
    public String newOrder(@RequestParam("bookId") int bookId,
                           @RequestParam("quantity") int quantity,
                           Model model) {

        Book book = new Book();
        book.setId(bookId);
        model.addAttribute("book", book);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(quantity);
        model.addAttribute("orderDetail", orderDetail);


        Order order = new Order();
        model.addAttribute("order", order);

        return "order-Info";
    }

    @RequestMapping("/mainPage")
    public String mainPage() {
        return "redirect:/book/getAllBook";
    }


}
