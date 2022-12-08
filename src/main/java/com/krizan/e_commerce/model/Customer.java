package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.CustomerRequest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
