package com.example.bookstore.dao;

import com.example.bookstore.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("from Book ");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }
}
