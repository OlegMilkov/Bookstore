package com.example.bookstore.restController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> showAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/allBooksByAuthor/{name}")
    public List<Book> showAllBooksByAuthor(@PathVariable String name) {
        List<Book> AllBooksByAuthor = bookService.getAllBooksByAuthor(name);
        return AllBooksByAuthor;
    }

    @GetMapping("/bookById/{id}")
    public Book showBookById(@PathVariable int id) {
        Book BookById = bookService.getBookById(id);
        return BookById;
    }

    @PostMapping("/addNewBook")
    public Book addNewBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "Book with id " + id + " was deleted";

    }


}





