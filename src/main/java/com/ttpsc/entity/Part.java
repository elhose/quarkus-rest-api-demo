package com.ttpsc.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
