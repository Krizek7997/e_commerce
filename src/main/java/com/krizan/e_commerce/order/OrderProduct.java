package com.krizan.e_commerce.order;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class OrderProduct {

    @EmbeddedId
    @Nullable
    private OrderProductPK pk;

    @NonNull
    private Integer quantity;

    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

}
