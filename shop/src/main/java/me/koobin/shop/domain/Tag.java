package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity @Builder @NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Embedded
    private BaseTimeEntity baseTimeEntity;
}
