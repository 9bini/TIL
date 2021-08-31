package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.entity.Product;

import javax.persistence.*;

@Entity
@Builder @NoArgsConstructor
@AllArgsConstructor
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