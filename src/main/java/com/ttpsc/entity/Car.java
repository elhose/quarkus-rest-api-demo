package com.ttpsc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

//    @PositiveOrZero
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String color;

    public Car(String name, BigDecimal price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
}
