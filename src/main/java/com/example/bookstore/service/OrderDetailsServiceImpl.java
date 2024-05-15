package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public List<OrderDetail>getAllOrderDetailsByOrder(int id){
        return orderDetailsRepository.findAllByOrderId(id);
    }

    @Override
    @Transactional
    public void saveOrderDetail(OrderDetail orderDetail) {
        try {
            orderDetailsRepository.save(orderDetail);

            Book book = orderDetail.getBook();

            if (book != null) {
                int currentQuantity = book.getQuantityInStock();
                int orderedQuantity = orderDetail.getQuantity();

                double bookprice = book.getPrice();
                int orderquantity = orderDetail.getQuantity();
                //  чи вистачає книг на складі  та зменшує кількість книг на кладі
                if (currentQuantity >= orderedQuantity) {
                    book.setQuantityInStock(currentQuantity - orderedQuantity);
                    bookService.saveBook(book);

                } else {
                    throw new RuntimeException("Not enough books in stock");
                }
                //розрахунок для totalPrice
                if (orderquantity != 0) {
                    orderDetail.setTotalPrice(bookprice * orderquantity);
                    orderDetailsRepository.save(orderDetail);
                } else {
                    throw new RuntimeException("Quantity = 0");
                }


            } else {
                throw new RuntimeException("Book not found in the order detail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing order detail: " + e.getMessage());
        }
    }

}
