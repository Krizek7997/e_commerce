package com.krizan.e_commerce.repository;

import com.krizan.e_commerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    List<ShoppingCart> findAllShoppingCarts();
    ShoppingCart findShoppingCartByShoppingCartId(Long shoppingCartId);
}
