package me.koobin.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
public class ProductOptionValue {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_OPTION_ID")
    private ProductOption productOption;

    private String value;
    private Long additionalAmount;
    private Long supplyPrice;

    public ProductOptionValue(ProductOption productOption, String value, Long additionalAmount, Long supplyPrice) {
        this.productOption = productOption;
        this.value = value;
        this.additionalAmount = additionalAmount;
        this.supplyPrice = supplyPrice;
    }
}
