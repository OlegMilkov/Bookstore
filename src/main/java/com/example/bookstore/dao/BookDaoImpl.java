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

    @Override
    public List<Book> getAllBooksByAuthor(String name) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.author.name = :authorName");
        query.setParameter("authorName", name);
        List<Book> result = query.getResultList();
        return result;
    }

    @Override
    public Book getBookById(int id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteBook(int id) {
        Query query = entityManager.createQuery("delete from Book " + "where id = :BookId");
        query.setParameter("BookId", id);
        query.executeUpdate();
    }
}
