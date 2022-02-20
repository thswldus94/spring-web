package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.controller.entity.OrderEntity;
import com.sonjy1994.hellospring.domain.Order;
import com.sonjy1994.hellospring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/list")
    public String list(Model model) {
        List<Order> orderList = orderService.getOrderList();
        model.addAttribute("orderList", orderList);
        return "order/orderList";
    }

    @PostMapping("/order/add_order")
    public String addOrder(@RequestBody List<OrderEntity> orderList) {
        orderService.addOrder(orderList);

//        System.out.println(">>> " + data.get("order_list"));
//        System.out.println(">>> " + data.get("store_idx"));

        // result = orderService.addOrder(storeIdx, foodList);
        // System.out.println(result);

        return "redirect:/";
    }
}
