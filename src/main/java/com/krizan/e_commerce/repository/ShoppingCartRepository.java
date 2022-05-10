package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findShoppingCartByShoppingCartId(Long shoppingCartId);
}
