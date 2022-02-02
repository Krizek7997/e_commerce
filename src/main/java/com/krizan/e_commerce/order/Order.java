package com.krizan.e_commerce.order;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long id;

    @OneToMany
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private LocalDate dateCreated;

    @Nullable
    private Integer numberOfProducts;

    @Nullable
    private Double totalPrice;

    @NonNull
    private String status;

    public Double calcTotalPrice() {
        Double total = 0D;
        for (Product p : products)
            total += p.getFinalUnitPrice();
        return total;
    }

    public Integer calcNumberOfProducts() {
        return products.size();
    }

}
