package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Location;
import com.sonjy1994.hellospring.domain.Store;

import java.util.List;

public interface StoreRepository {
    Store save(Store store);
    List<Store> findAll();
}
