package me.koobin.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor
public class SearchFilterContentProduct {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDENTIFICATION_DETAIL_CODE_ID")
    private IdentificationDetailCode identificationDetailCode;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private TagProduct.Product product;

    public SearchFilterContentProduct(IdentificationDetailCode identificationDetailCode, TagProduct.Product product) {
        this.identificationDetailCode = identificationDetailCode;
        this.product = product;
    }
}
