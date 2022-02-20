package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.controller.entity.OrderEntity;
import com.sonjy1994.hellospring.domain.Order;
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

    public String addOrder(List<OrderEntity> entityList) {
//        // validate store for duplicate
//        validateDuplicateStore(store);
        String orderKey = getRandomOrderKey();

        for (int i = 0; i < entityList.size(); i++) {
            OrderEntity entity = entityList.get(i);

            Order order = new Order();

            order.setOrderKey(orderKey);
            // test user id (login 연동하면 바꿀 예정)
            order.setUserIdx(1L);
            order.setStoreIdx(entity.getStoreIdx());
            order.setFoodIdx(entity.getFoodIdx());

            // UserOrder userOrder = new UserOrder();
            // order.userOrder.setUserOrderKey(orderKey);
            // test user id (login 연동하면 바꿀 예정)
            // order.setUserUserIdx(1L);

            // UserOrder userOrder = new

            orderRepository.save(order);
        }

        return orderKey;
    }

    private static String getRandomOrderKey() {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String chars[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

        for (int i = 0 ; i < 32 ; i++) {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }

//    private void validateDuplicateStore(Store store) {
//        storeRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원임!!");
//                });
//    }
}
