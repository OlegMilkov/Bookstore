package com.example.bookstore.controller;

import com.example.bookstore.entity.OrderDetail;
import com.example.bookstore.entity.Roles;
import com.example.bookstore.entity.Users;
import com.example.bookstore.service.*;
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
    private final UserService userService;
    private final RolesService rolesService;

    public AdminController(OrderDetailsService orderDetailsService, OrderService orderService, UserService userService, RolesService rolesService) {
        this.orderDetailsService = orderDetailsService;
        this.orderService = orderService;
        this.userService = userService;
        this.rolesService = rolesService;
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
            if (!orderDetail.getCompleted()) {
                redirectAttributes.addFlashAttribute("errorMessage", "Ви не можете видалити поки " +
                        "всі замовлення  одного Order ID  будуть ✔ Completed");
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

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<Users> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users-page";
    }

    @GetMapping("/updateUserRole")
    public String updateUserRole(@RequestParam("userId") int userId,@RequestParam("newRole") String newRole) {
        Users users= userService.getUserById(userId);
        Roles role = rolesService.getRoleByName(newRole);

        if (role != null) {
            users.setRoles(role); // Оновлюємо роль користувача
            userService.saveUser(users); // Зберігаємо зміни в базі
        }

        return "redirect:/admin/allUsers";
    }
}
