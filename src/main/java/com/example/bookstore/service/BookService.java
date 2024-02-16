package com.example.bookstore.service;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book>getAllBooks();

    public List<Book> getAllBooksByAuthor(String name);

    public Book getBookById(int id);

    public void saveBook(Book book);

    public  void deleteBook(int id);

}
