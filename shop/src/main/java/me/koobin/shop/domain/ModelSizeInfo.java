package me.koobin.shop.domain;

import me.koobin.shop.entity.Product;

import javax.persistence.*;

@Entity
public class ModelSizeInfo {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Enumerated
    private Gender gender;
    private Float height;
    private Float weight;
    private String wearingSize;
    @Enumerated
    private FitType fitType;

}
