package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private String postalCode;
    @OneToMany(mappedBy = "customer")
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
