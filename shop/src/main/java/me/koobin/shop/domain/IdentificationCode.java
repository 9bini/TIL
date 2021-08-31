package me.koobin.shop.domain;

import javax.persistence.*;

@Entity
public class IdentificationCode {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    private String code;

    @Column(nullable = false )
    private String name;

    @Column(nullable = false)
    private String description;
}
