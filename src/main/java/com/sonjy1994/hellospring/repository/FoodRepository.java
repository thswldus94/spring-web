package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Food;

import java.util.List;

public interface FoodRepository {
    List<Food> findByStoreIdx(Long storeIdx);
}
