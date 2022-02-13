package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.repository.FoodRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// jpa는 트랜잭션 필요함
@Transactional
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getFoodListByStoreIdx(Long storeIdx) {
        return foodRepository.findByStoreIdx(storeIdx);
    }
}
