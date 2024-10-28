package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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
    private double price;
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


    public Book(String title, String photo, double price, int quantityInStock, Author author) {
        this.title = title;
        this.photo = photo;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.author = author;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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



//    public List<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && Double.compare(getPrice(), book.getPrice()) == 0 && getQuantityInStock() == book.getQuantityInStock() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getPhoto(), book.getPhoto());
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", author=" + author.getName() +
                '}';
    }
}
