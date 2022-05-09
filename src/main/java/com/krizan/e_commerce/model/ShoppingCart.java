package com.krizan.e_commerce.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Table(name = "shopping_carts")
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long shoppingCartId;

    @OneToMany
    private List<ShoppingCartEntry> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
}
