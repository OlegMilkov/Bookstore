package com.example.bookstore.entity;

import jakarta.persistence.*;


    @Entity
    @Table(name = "order_details")
    public class OrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_detail_id")
        private Long orderDetailId;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "book_id")
        private Book book;

        @Column(name = "quantity")
        private Integer quantity;

        @Column(name = "total_price")
        private Double totalPrice;

        public OrderDetail() {
        }

        public OrderDetail(Order order, Book book, Integer quantity, Double totalPrice) {
            this.order = order;
            this.book = book;
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }

        public Long getOrderDetailId() {
            return orderDetailId;
        }

        public void setOrderDetailId(Long orderDetailId) {
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

        @Override
        public String toString() {
            return "OrderDetail{" +
                    "order=" + order +
                    ", book=" + book +
                    ", quantity=" + quantity +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

