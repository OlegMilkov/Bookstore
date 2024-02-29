package com.example.bookstore.dao;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String name) {

        return bookRepository.findByAuthorName(name);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public void saveBook(Book book) {
       bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
