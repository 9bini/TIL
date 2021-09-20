package me.koobin.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
