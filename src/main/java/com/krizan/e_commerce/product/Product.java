package com.krizan.e_commerce.product;

import com.krizan.e_commerce.category.Category;
import com.krizan.e_commerce.vendor.Vendor;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nullable
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @NonNull
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NonNull
    private Category category;

    @NonNull
    private String name;

    @Nullable
    private String description;

    @NonNull
    private String color;

    @NonNull
    private String size;

    @NonNull
    private Double unitPrice;

    @NonNull
    private Boolean discountAvailable;

    @NonNull
    private Integer discount;

    @Nullable
    private Double finalUnitPrice;

    @NonNull
    private Boolean onOrder;

    @NonNull
    private Integer quantity;

    public Double calcFinalUnitPrice() {
        Double discountInDecimal = Double.valueOf(discount) / 100;
        return unitPrice - unitPrice * discountInDecimal;
    }
}
