package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Builder @NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;


}
