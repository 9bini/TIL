package me.koobin.shop.entity;


import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private LocalDate startSalesPeriod;
    @Column(nullable = false)
    private LocalDate endSalesPeriod;


    @Embedded
    private BaseTimeEntity baseTimeEntity;

}
