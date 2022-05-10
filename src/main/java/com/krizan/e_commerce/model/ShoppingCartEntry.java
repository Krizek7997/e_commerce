package com.krizan.e_commerce.model;

import lombok.*;
import org.springframework.lang.Nullable;

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
    @Nullable
    private Long id;

    @ManyToOne
    private Product product;

    private Integer amount;

    public ShoppingCartEntry(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }
}
