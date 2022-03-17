package com.krizan.e_commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private LocalDateTime dateCreated;

    @Nullable
    private Integer numberOfProducts;

    @Nullable
    private BigDecimal totalOrderPrice;

    @NonNull
    private String status;

    public BigDecimal calcTotalOrderPrice() {
        BigDecimal total = BigDecimal.ZERO;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct oP : orderProducts) total = total.add(oP.getTotalPrice());
        return total;
    }

    public Integer calcNumberOfProducts() {
        return orderProducts.size();
    }

}
