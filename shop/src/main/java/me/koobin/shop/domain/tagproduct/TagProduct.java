package me.koobin.shop.domain.tagproduct;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.product.Product;
import me.koobin.shop.domain.tag.Tag;
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
