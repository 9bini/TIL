package me.koobin.shop.domain;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"code", "name"}))
public class IdentificationCode {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false ,unique = true)
    private String name;

    @Column(nullable = false)
    private String description;
}
