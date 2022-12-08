package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.ShoppingCartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ShoppingCartEntryRepository extends JpaRepository<ShoppingCartEntry, Long> {

    Optional<ShoppingCartEntry> findShoppingCartEntryById(Long id);
}
