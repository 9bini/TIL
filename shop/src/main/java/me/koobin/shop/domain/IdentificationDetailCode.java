package me.koobin.shop.domain;

import javax.persistence.*;

@Entity
public class IdentificationDetailCode {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTIFICATION_CODE_ID", nullable = false)
    private IdentificationCode identificationCode;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private String label;


}
