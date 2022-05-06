package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long customerId;

    @NonNull
    private String firstName;

    @NonNull
    private String surname;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String address;

    @NonNull
    private String postalCode;

    @Nullable
    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Order> orders;

    public Customer(CustomerRequest request) {
        this.firstName = request.getFirstName();
        this.surname = request.getSurname();
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
        this.address = request.getAddress();
        this.postalCode = request.getPostalCode();
        this.orders = new ArrayList<>();
    }

}
