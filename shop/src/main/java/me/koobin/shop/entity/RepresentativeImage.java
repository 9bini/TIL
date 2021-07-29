package me.koobin.shop.entity;

import javax.persistence.*;


@Entity
public class RepresentativeImage {

    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;


}