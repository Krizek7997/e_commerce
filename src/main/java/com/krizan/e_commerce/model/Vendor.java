package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.VendorRequest;
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
@Table(name = "vendors")
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long vendorId;

    @NonNull
    private String name;

    @NonNull
    private String country;

    @NonNull
    private String address;

    @NonNull
    private String postalCode;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @Nullable
    private String url;

    @OneToMany(mappedBy = "vendor")
    @Nullable
    @ToString.Exclude
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
