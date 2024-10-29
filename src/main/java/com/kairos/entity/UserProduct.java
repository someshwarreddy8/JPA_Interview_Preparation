package com.kairos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_product",
        uniqueConstraints = {
                @UniqueConstraint(name = "name_price_unique_constraint", columnNames = {"name", "price"})
        })
public class UserProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private String price;
    private String area;
    private String street;

}
