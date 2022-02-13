package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/food/list")
    public String list(@RequestParam("storeIdx") Long storeIdx, Model model) {
        List<Food> foodList = foodService.getFoodListByStoreIdx(storeIdx);
        model.addAttribute("foodList", foodList);
        return "food/foodList";
    }
}
