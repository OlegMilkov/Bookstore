package com.example.bookstore.service;

import com.example.bookstore.dao.BookDao;
import com.example.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    @Transactional
    public List<Book> getAllBooksByAuthor(String name) {
        return bookDao.getAllBooksByAuthor(name);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDao.deleteBook(id);

    }


}
