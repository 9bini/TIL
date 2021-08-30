package me.koobin.shop.domain;

import me.koobin.shop.entity.Product;

import javax.persistence.*;

@Entity
public class ProductOption {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    private String name;
    private boolean requireOption;

}
