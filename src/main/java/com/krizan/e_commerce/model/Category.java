package com.krizan.e_commerce.model;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long categoryId;

    @NonNull
    private String name;

}
