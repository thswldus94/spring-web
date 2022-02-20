package com.sonjy1994.hellospring;

import com.sonjy1994.hellospring.aop.TimeTraceAop;
import com.sonjy1994.hellospring.repository.*;
import com.sonjy1994.hellospring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    // 스프링빈에 등록시키기
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public StoreService storeService() {
        return new StoreService(storeRepository());
    }

    @Bean
    public StoreRepository storeRepository() {
        return new JpaStoreRepository(em);
    }

    @Bean
    public FoodService foodService() {
        return new FoodService(foodRepository());
    }

    @Bean
    public FoodRepository foodRepository() {
        return new JpaFoodRepository(em);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository(em);
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepository(em);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
