package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.domain.Pay;

import java.util.List;

public interface PayRepository {
    Pay save(Pay store);
    List<Pay> findAll();
    List<Food> findFoodByOrderIdx(Long orderIdx);
}
