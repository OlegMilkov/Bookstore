package com.example.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


    @Entity
    @Table(name = "order_details")
    public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_detail_id")
        private int orderDetailId;

        @ManyToOne
        @JoinColumn(name = "order_id" )
        private Order order;

        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book book;

        @Column(name = "quantity")
        private Integer quantity;

        @Column(name = "total_price")
        private Double totalPrice;

        @Column(name = "completed")
        private Boolean completed;

        public OrderDetail() {
        }

        public OrderDetail(Order order, Book book, Integer quantity, Double totalPrice) {
            this.order = order;
            this.book = book;
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }


        public int getOrderDetailId() {
            return orderDetailId;
        }

        public void setOrderDetailId(int orderDetailId) {
            this.orderDetailId = orderDetailId;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Boolean getCompleted() {
            return completed;
        }

        public void setCompleted(Boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "OrderDetail{" +
                    "orderDetailId=" + orderDetailId +
                    ", order=" + order +
                    ", book=" + book +
                    ", quantity=" + quantity +
                    ", totalPrice=" + totalPrice +
                    ", completed=" + completed +
                    '}';
        }


    }

