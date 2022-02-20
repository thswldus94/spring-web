package com.sonjy1994.hellospring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`") // order는 예약어라서 ` ` 로 감싸주어야 함
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(name = "order_key")
    private String orderKey;
    @Column(name = "user_idx")
    private Long userIdx;
    @Column(name = "store_idx")
    private Long storeIdx;
    @Column(name = "food_idx")
    private Long foodIdx;
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public Long getStoreIdx() {
        return storeIdx;
    }

    public void setStoreIdx(Long storeIdx) {
        this.storeIdx = storeIdx;
    }

    public Long getFoodIdx() {
        return foodIdx;
    }

    public void setFoodIdx(Long foodIdx) {
        this.foodIdx = foodIdx;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @PrePersist
    public void setCreatedTime() {
        this.createdTime = LocalDateTime.now();
    }

//    @OneToOne(mappedBy = "user_order")
//    private UserOrder userOrder;
}

//@Entity
//@Table(name = "user_order")
//class UserOrder {
//    @Column(name = "order_key", table = "user_order")
//    private String userOrderKey;
//    @Column(name = "user_idx", table = "user_order")
//    private Long userUserIdx;
//
//
//    public String getUserOrderKey() {
//        return userOrderKey;
//    }
//
//    public void setUserOrderKey(String userOrderKey) {
//        this.userOrderKey = userOrderKey;
//    }
//
//    public Long getUserUserIdx() {
//        return userUserIdx;
//    }
//
//    public void setUserUserIdx(Long userUserIdx) {
//        this.userUserIdx = userUserIdx;
//    }
//}