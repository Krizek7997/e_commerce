package com.krizan.e_commerce.customer;

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
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long id;

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
    private Integer postalCode;

}
