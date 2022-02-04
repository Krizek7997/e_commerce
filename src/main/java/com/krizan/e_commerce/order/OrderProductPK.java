package com.krizan.e_commerce.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.krizan.e_commerce.product.Product;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class OrderProductPK implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

}
