package me.koobin.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @Getter
public class ProductOption {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private String name;

    private Boolean requireOption;

    @Builder
    public ProductOption(Product product, String name, Boolean requireOption) {
        this.product = product;
        this.name = name;
        this.requireOption = requireOption;
    }
}
