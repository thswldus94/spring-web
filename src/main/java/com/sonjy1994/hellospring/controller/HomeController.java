package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.controller.entity.StoreEntity;
import com.sonjy1994.hellospring.domain.Store;
import com.sonjy1994.hellospring.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final StoreService storeService;

    @Autowired
    public HomeController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("abc");
        List<Store> storeList = storeService.getStoreList();
        model.addAttribute("storeList", storeList);

        String[] locationList = {"서울", "경기", "인천", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};

        model.addAttribute("locationList", locationList);
        return "home";
    }
}
