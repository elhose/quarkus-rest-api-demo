package com.ttpsc.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String color;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Part> parts;

    public Car() {}

    public Car(String name, BigDecimal price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
}
