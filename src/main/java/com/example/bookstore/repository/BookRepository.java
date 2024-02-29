package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorName(String authorName);
}
