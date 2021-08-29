package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.entity.Product;

import javax.persistence.*;


@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
public class SizeChart {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private Integer sizeName;
    private Integer totalLength;
    private Integer shoulderWidth;
    private Integer sleeveLength;
    private Integer waistWidth;
    private Integer hipWidth;
    private Integer crotchWidth;
    private Integer thighWidth;
    private Integer hemWidth;
}