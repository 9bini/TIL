package me.koobin.shop.entity;


import me.koobin.shop.domain.ProductGender;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductGender productGender;

    @Column(length = 100, nullable = false)
    private String exposedProductName;

    @Column(length = 100, nullable = false)
    private String companyProductName;

    @Column(length = 20, nullable = false)
    private String additionalText;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    private String productPrecautions;
    private String orderPrecautions;
    private String deliveryPrecautions;
    private String basicExplanation;



    @Embedded
    private BaseTimeEntity baseTimeEntity;

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public static void newProduct() {
    }
}
