package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.utils.Gender;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Nullable
    private Integer discount;

    @Nullable
    private BigDecimal finalUnitPrice;

    @NonNull
    private Integer quantity;

    public Product(ProductRequest request, Category category, Vendor vendor) {
        this.vendor = vendor;
        this.gender = request.getGender();
        this.category = category;
        this.name = request.getName();
        this.description = request.getDescription();
        this.color = request.getColor();
        this.size = request.getSize();
        this.unitPrice = request.getUnitPrice();
        this.finalUnitPrice = calcFinalUnitPrice();
        this.discountAvailable = false;
        this.quantity = request.getQuantity();
    }

    public BigDecimal calcFinalUnitPrice() {
        if (discount != null) {
            BigDecimal discountInBigDecimal = BigDecimal.valueOf(discount)
                    .divide(BigDecimal.valueOf(100), RoundingMode.UNNECESSARY);
            return unitPrice.subtract(unitPrice.multiply(discountInBigDecimal));
        } else return unitPrice;
    }
}
