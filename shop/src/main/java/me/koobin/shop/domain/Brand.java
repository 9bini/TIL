package me.koobin.shop.domain;

import javax.persistence.*;

@Entity
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;


}
