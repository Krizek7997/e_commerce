package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.ProductRequest;
import com.krizan.e_commerce.utils.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String description;
    private String color;
    private String size;
    private BigDecimal unitPrice;
    private Boolean discountAvailable;
    private Integer discount;
    private BigDecimal finalUnitPrice;
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
