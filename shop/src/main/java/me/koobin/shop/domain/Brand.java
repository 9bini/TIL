package me.koobin.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;


}
