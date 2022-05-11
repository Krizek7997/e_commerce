package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.VendorRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "vendors")
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String address;
    private String postalCode;
    private String email;
    private String phoneNumber;
    private String url;

    @OneToMany(mappedBy = "vendor", orphanRemoval = true)
    private List<Product> products;

    public Vendor(VendorRequest request) {
        this.name = request.getName();
        this.country = request.getCountry();
        this.address = request.getAddress();
        this.postalCode = request.getPostalCode();
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
        this.url = request.getUrl();
        this.products = new ArrayList<>();
    }
}
