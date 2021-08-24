package me.koobin.shop.domain;

import me.koobin.shop.entity.Product;

import javax.persistence.*;

@Entity
public class ProductOptionValue {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_OPTION_ID")
    private ProductOption productOption;

    private String value;
    private Long additionalAmount;
    private Long supplyPrice;

}
