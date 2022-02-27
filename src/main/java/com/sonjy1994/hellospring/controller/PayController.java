package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.controller.entity.PayEntity;
import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.domain.Pay;
import com.sonjy1994.hellospring.service.PayService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class PayController {

    private final PayService payService;

    @Autowired
    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping("/pay/confirm")
    public String confirm(@RequestParam("orderIdx") Long orderIdx, Model model) {
        List<Food> foodList = payService.getFoodListByOrderIdx(orderIdx);

        Long sumPrice = 0L;
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            sumPrice = sumPrice + food.getPrice();
        }

        model.addAttribute("foodList", foodList);
        model.addAttribute("sumPrice", sumPrice);

        return "pay/confirm";
    }

//    @PostMapping("/order/add_order")
//    @ResponseBody
//    public String addOrder(@RequestBody OrderEntity entity) {
//
//        Long orderIdx = orderService.addOrder(entity);
//
//        JSONObject obj = new JSONObject();
//        obj.put("orderIdx", orderIdx);
//
//        return obj.toJSONString();
//    }
}
