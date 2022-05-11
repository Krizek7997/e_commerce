package com.krizan.e_commerce.model;

import com.krizan.e_commerce.dto.request.CategoryRequest;
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
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(CategoryRequest request) {
        this.name = request.getName();
        this.products = new ArrayList<>();
    }

}
