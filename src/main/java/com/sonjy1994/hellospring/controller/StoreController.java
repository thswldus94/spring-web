package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.domain.Store;
import com.sonjy1994.hellospring.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/store/list")
    public String list(Model model) {
        List<Store> storeList = storeService.getStoreList();
        model.addAttribute("storeList", storeList);
        return "store/storeList";
    }
}
