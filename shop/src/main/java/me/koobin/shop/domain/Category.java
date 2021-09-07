package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.converter.BooleanToYNConverter;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder @Getter
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category parent;

    // 카테고리 순서를 정하기 위해서
    private Long sort;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private Boolean disabled;


    private Float sellingCommission;

    @Embedded
    private BaseTimeEntity baseTimeEntity;



}