package me.koobin.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor
public class ProductOption {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private TagProduct.Product product;
    private String name;
    private Boolean require;

    public ProductOption(TagProduct.Product product, String name, Boolean require) {
        this.product = product;
        this.name = name;
        this.require = require;
    }
}
