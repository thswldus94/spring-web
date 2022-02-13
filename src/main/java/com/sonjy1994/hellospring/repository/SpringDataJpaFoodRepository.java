package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, pk타입>
public interface SpringDataJpaFoodRepository extends JpaRepository<Food, Long>, FoodRepository {
}
