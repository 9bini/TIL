package me.koobin.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import me.koobin.shop.utils.BaseTimeEntity;

@Entity @NoArgsConstructor
public class TagProduct extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    public TagProduct(Tag tag, Product product) {
        this.tag = tag;
        this.product = product;
    }



}
