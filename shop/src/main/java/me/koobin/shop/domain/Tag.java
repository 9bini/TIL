package me.koobin.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
}
