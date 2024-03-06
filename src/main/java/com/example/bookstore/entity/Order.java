package com.example.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_surname")
    private String surname;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "post_office")
    private int post_office;

    @Column(name = "order_date" ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order" ,cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String name, String surname, String email, String phone, int post_office, LocalDateTime orderDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.post_office = post_office;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPost_office() {
        return post_office;
    }

    public void setPost_office(int post_office) {
        this.post_office = post_office;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", post_office=" + post_office +
                ", orderDate=" + orderDate +
                '}';
    }
}


