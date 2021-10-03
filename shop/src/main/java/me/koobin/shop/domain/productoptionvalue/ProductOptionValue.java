package me.koobin.shop.domain.productoptionvalue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.productoption.ProductOption;

@Entity @NoArgsConstructor
@Getter
public class ProductOptionValue {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_OPTION_ID")
    private ProductOption productOption;

    private String valueName;
    private Long additionalAmount;
    private Long supplyPrice;


    @Builder
    public ProductOptionValue(ProductOption productOption, String valueName, Long additionalAmount, Long supplyPrice) {
        this.productOption = productOption;
        this.valueName = valueName;
        this.additionalAmount = additionalAmount;
        this.supplyPrice = supplyPrice;
    }
}
