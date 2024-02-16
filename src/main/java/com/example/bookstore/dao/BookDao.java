package com.example.bookstore.dao;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookDao {

    public List<Book> getAllBooks();

    public List<Book> getAllBooksByAuthor(String name);

    public Book getBookById(int id);

    public void saveBook(Book book);

    public void deleteBook(int id);

}
