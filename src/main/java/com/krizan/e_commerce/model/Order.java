package com.krizan.e_commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.krizan.e_commerce.utils.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateCreated;
    private Integer numberOfProducts;
    private BigDecimal totalOrderPrice;
    private OrderStatus status;
    private Boolean payed;

    public Order(ShoppingCart shoppingCart, Customer customer) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.dateCreated = LocalDateTime.parse(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        this.numberOfProducts = calcNumberOfProducts();
        this.totalOrderPrice = calcTotalOrderPrice();
        this.status = OrderStatus.WAITING;
        this.payed = false;
    }

    private BigDecimal calcTotalOrderPrice() {
        var total = BigDecimal.ZERO;
        for (var entry: shoppingCart.getProducts()) {
            total = total.add(BigDecimal.valueOf(entry.getAmount())
                    .multiply(entry.getProduct().getFinalUnitPrice()));
        }
        return total;
    }

    private Integer calcNumberOfProducts() {
        Integer total = 0;
        for (var product: shoppingCart.getProducts()) {
            total += product.getAmount();
        }
        return total;
    }
}
