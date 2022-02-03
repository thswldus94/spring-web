package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, pk타입>
public interface SpringDataJpaStoreRepository extends JpaRepository<Store, Long>, StoreRepository {
}
