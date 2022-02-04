package com.krizan.e_commerce.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.krizan.e_commerce.customer.Customer;
import com.krizan.e_commerce.product.Product;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nullable
    private Long id;

    @NonNull
    @ManyToOne()
    @ToString.Exclude
    private Customer customer;

    @OneToMany(mappedBy = "")
    @ToString.Exclude
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private LocalDate dateCreated;

    @Nullable
    private Integer numberOfProducts;

    @Nullable
    private Double totalOrderPrice;

    @NonNull
    private String status;

    public Double calcTotalOrderPrice() {
        Double total = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct oP : orderProducts) total += oP.getFinalUnitPrice();
        return total;
    }

    public Integer calcNumberOfProducts() {
        return orderProducts.size();
    }

}
