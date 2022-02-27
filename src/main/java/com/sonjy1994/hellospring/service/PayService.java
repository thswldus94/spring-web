package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.domain.Pay;
import com.sonjy1994.hellospring.repository.PayRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// jpa는 트랜잭션 필요함
@Transactional
public class PayService {

    private final PayRepository payRepository;

    public PayService(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    public List<Pay> getPayList() {
        return payRepository.findAll();
    }

    public List<Food> getFoodListByOrderIdx(Long orderIdx) {
        System.out.println(payRepository.findFoodByOrderIdx(orderIdx));
        return payRepository.findFoodByOrderIdx(orderIdx);
    }
}
