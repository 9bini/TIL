package me.koobin.shop.entity;

import me.koobin.shop.converter.BooleanToYNConverter;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class CategoryOptionItem {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_OPTION_ID")
    @Column(nullable = false)
    private CategoryOption categoryOption;

    @Column(nullable = false)
    private String name;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private Boolean disabled;

    @Embedded
    private BaseTimeEntity baseTimeEntity;
}
