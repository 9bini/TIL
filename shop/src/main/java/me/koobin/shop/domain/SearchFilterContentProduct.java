package me.koobin.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
public class SearchFilterContentProduct {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTIFICATION_DETAIL_CODE_ID")
    private IdentificationDetailCode identificationDetailCode;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public SearchFilterContentProduct(IdentificationDetailCode identificationDetailCode, Product product) {
        this.identificationDetailCode = identificationDetailCode;
        this.product = product;
    }
}
