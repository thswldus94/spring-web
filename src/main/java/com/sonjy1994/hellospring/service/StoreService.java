package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Location;
import com.sonjy1994.hellospring.domain.Store;
import com.sonjy1994.hellospring.repository.StoreRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// jpa는 트랜잭션 필요함
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStoreList() {
        return storeRepository.findAll();
    }

    public Long addStore(Store store) {
//        // validate store for duplicate
//        validateDuplicateStore(store);

        storeRepository.save(store);
        return store.getIdx();
    }

//    private void validateDuplicateStore(Store store) {
//        storeRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원임!!");
//                });
//    }
}
