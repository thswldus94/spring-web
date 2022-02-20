package com.sonjy1994.hellospring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_food")
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(table = "order_food", name = "order_idx")
    private String orderIdx;

    @Column(table = "order_food", name = "food_idx")
    private Long foodIdx;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getOrderIdx() {
        return orderIdx;
    }

    public void setOrderIdx(String orderIdx) {
        this.orderIdx = orderIdx;
    }

    public Long getFoodIdx() {
        return foodIdx;
    }

    public void setFoodIdx(Long foodIdx) {
        this.foodIdx = foodIdx;
    }
}