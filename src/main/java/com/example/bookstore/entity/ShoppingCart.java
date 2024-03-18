package com.example.bookstore.entity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCart {

    public List<Book> books;



    public ShoppingCart(List<Book> books) {
        this.books = books;
    }

    // Метод для додавання книги в корзину
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод для видалення книги з корзини
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Метод для очищення корзини
    public void clear(Book book) {
        books.clear();
    }

    // Метод для отримання списку книг у корзині
    public List<Book> getBooks() {
        return books;
    }

    // Метод для обчислення загальної вартості товарів у корзині
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
