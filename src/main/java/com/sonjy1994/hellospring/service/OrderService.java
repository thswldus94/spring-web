package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.controller.entity.OrderEntity;
import com.sonjy1994.hellospring.domain.Order;
import com.sonjy1994.hellospring.domain.OrderFood;
import com.sonjy1994.hellospring.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

// jpa는 트랜잭션 필요함
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public Long addOrder(OrderEntity entity) {
        Order order = new Order();
        // test 유저 용 로그인 기능 생기면 뺄거임
        order.setUserIdx(1L);
        order.setStoreIdx(entity.getStoreIdx());

        List<Long> foodIdxList = entity.getFoodIdxList();
        for (int i = 0; i < foodIdxList.size(); i++) {
            OrderFood orderFood = new OrderFood();
            orderFood.setFoodIdx(foodIdxList.get(i));

            order.addOrderFood(orderFood);
        }

        Order result = orderRepository.save(order);

        return result.getIdx();
    }
}
