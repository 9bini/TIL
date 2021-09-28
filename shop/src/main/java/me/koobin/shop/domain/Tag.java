package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import me.koobin.shop.utils.BaseTimeEntity;

@Entity @Builder @NoArgsConstructor
@AllArgsConstructor @Getter
public class Tag extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
}
