package com.krizan.e_commerce.order;

import com.krizan.e_commerce.product.Product;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "order_products")
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @NonNull
    private Integer quantity;

    public Double getTotalPrice() {
        if (getProduct().getFinalUnitPrice() != null) {
            return getProduct().getFinalUnitPrice() * getQuantity();
        } else throw new NullPointerException();
    }
}
