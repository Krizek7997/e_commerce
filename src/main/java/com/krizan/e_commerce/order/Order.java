package com.krizan.e_commerce.order;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Nullable
    private Long id;
}
