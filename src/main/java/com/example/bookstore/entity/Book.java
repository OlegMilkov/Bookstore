package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "photo")
    private String photo;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @OneToMany(mappedBy = "book")
    private List<OrderDetail> orderDetails;

//-------------------------------------------------------------------------------------------
    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "author_id")
    private Author author;
//-------------------------------------------------------------------------------------------

    public Book() {
    }

    public Book(String title, String photo, Double price, int quantityInStock ) {
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.quantityInStock=quantityInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", author=" + author +
                '}';
    }
}
