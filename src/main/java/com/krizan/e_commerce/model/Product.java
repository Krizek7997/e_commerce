package com.krizan.e_commerce.model;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @NonNull
    private Gender gender;

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
    private BigDecimal unitPrice;

    @NonNull
    private Boolean discountAvailable;

    @NonNull
    private Integer discount;

    @Nullable
    private BigDecimal finalUnitPrice;

    @NonNull
    private Boolean onOrder;

    @NonNull
    private Integer quantity;

    public BigDecimal calcFinalUnitPrice() {
        BigDecimal discountInBigDecimal = BigDecimal.valueOf(getDiscount())
                .divide(BigDecimal.valueOf(100), RoundingMode.UNNECESSARY);
        return unitPrice.subtract(unitPrice.multiply(discountInBigDecimal));
    }
}
