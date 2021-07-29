package me.koobin.shop.entity;

import me.koobin.shop.converter.BooleanToYNConverter;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class CategoryOption {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @Column(nullable = false)
    private Category category;


    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private Boolean disabled;

    @Embedded
    private BaseTimeEntity baseTimeEntity;

}
