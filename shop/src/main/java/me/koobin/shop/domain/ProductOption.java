package me.koobin.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor
public class ProductOption {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    private String name;

    private Boolean requireOption;

    public ProductOption(Product product, String name, Boolean requireOption) {
        this.product = product;
        this.name = name;
        this.requireOption = requireOption;
    }
}
