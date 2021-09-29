package me.koobin.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IdentificationDetailCode {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTIFICATION_CODE_ID", nullable = false)
    private IdentificationCode identificationCode;

    @Column(nullable = false)
    private String label;
}
