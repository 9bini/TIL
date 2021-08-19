package me.koobin.shop.entity;

import javax.persistence.*;

@Table(name = "brand")
@Entity
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;


}