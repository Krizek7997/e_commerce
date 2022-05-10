package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.CategoryRequest;
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
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Nullable
    private Long categoryId;

    @NonNull
    private String name;

    @Nullable
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(CategoryRequest request) {
        this.name = request.getName();
        this.products = new ArrayList<>();
    }

}
