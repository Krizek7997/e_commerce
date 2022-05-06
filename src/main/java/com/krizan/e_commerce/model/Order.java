package com.krizan.e_commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.krizan.e_commerce.utils.OrderStatus;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long orderId;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @NonNull
    @ToString.Exclude
    private List<OrderProduct> orderProducts;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private LocalDateTime dateCreated;

    @Nullable
    private Integer numberOfProducts;

    @Nullable
    private BigDecimal totalOrderPrice;

    @Nullable
    private OrderStatus status;
}
