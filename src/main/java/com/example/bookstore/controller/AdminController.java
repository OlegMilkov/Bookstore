package com.example.bookstore.controller;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.service.OrderDetailsService;
import com.example.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final OrderDetailsService orderDetailsService;
    private final OrderService orderService;

    public AdminController(OrderDetailsService orderDetailsService, OrderService orderService) {
        this.orderDetailsService = orderDetailsService;
        this.orderService = orderService;
    }

    @GetMapping("/allOrderDetails")
    public String getAllOrderDetails(Model model) {
        List<OrderDetail> orderDetails = orderDetailsService.getAllOrderDetails();
        model.addAttribute("orderDetails", orderDetails);
        return "admin-page";
    }


    @DeleteMapping("/delete")
    public String deleteOrderDetail_and_Order(@RequestParam("orderId") int orderId,
                                              RedirectAttributes redirectAttributes) {
        List<OrderDetail> orderDetails = orderDetailsService.getAllOrderDetailsByOrder(orderId);
        for (OrderDetail orderDetail : orderDetails) {
            if (!orderDetail.getCompleted()){
                redirectAttributes.addFlashAttribute("errorMessage", "Ви не можете видалити поки " +
                        "всі замовлення  Order ID  будуть ✔ Completed");
                return "redirect:/admin/allOrderDetails";
            }
        }
        orderService.deleteOrder(orderId);

        return "redirect:/admin/allOrderDetails";
    }


    @PostMapping("/update-completed")
    public String updateCompleted(@RequestParam("orderDetailId") int orderDetailId) {
        orderDetailsService.updateCompleted(orderDetailId);

        return "redirect:/admin/allOrderDetails";
    }
}
