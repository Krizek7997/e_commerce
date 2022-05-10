package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.ShoppingCartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartEntryRepository extends JpaRepository<ShoppingCartEntry, Long> {

    ShoppingCartEntry getShoppingCartEntryById(Long id);
}
