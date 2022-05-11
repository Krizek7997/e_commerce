package com.krizan.e_commerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "shopping_cart_entries")
@Entity
public class ShoppingCartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    private Product product;

    private Integer amount;

    public ShoppingCartEntry(Product product, Integer amount, ShoppingCart shoppingCart) {
        this.product = product;
        this.amount = amount;
        this.shoppingCart = shoppingCart;
    }
}
