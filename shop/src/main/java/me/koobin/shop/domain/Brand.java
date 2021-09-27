package me.koobin.shop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.utils.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter
@NoArgsConstructor
public class Brand extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Builder
    public Brand(String name) {
        this.name = name;
    }
}
