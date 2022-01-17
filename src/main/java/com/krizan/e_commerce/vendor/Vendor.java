package com.krizan.e_commerce.vendor;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long id;

    @NonNull
    private String companyName;

    @NonNull
    private String country;

    @NonNull
    private String address;

    @NonNull
    private Integer postalCode;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @Nullable
    private String url;

}
