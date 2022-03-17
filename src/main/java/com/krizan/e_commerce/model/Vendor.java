package com.krizan.e_commerce.model;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
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
    private List<Product> productList;

}
