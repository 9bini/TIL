package me.koobin.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @NoArgsConstructor
public class ProductOptionDetail {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_OPTION_ID")
    private ProductOption productOption;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_OPTION_VALUE_ID")
    private ProductOptionValue productOptionValue;

    private Long optionAdditionalPrice;
    private Long maxPurchaseQuantity;
    @NotNull(message = "최대 구매수량 제한없음은 필수 입니다.")
    private Boolean maxUnlimited;
    private SalesStatus salesStatus;

    @NotNull(message = "수량 한정여부는 필수 입니다.")
    private Boolean quantityUnlimited;
    private Long quantity;

    public ProductOptionDetail(ProductOption productOption, ProductOptionValue productOptionValue, Long optionAdditionalPrice, Long maxPurchaseQuantity, Boolean maxUnlimited, SalesStatus salesStatus, Boolean quantityUnlimited, Long quantity) {
        this.productOption = productOption;
        this.productOptionValue = productOptionValue;
        this.optionAdditionalPrice = optionAdditionalPrice;
        this.maxPurchaseQuantity = maxPurchaseQuantity;
        this.maxUnlimited = maxUnlimited;
        this.salesStatus = salesStatus;
        this.quantityUnlimited = quantityUnlimited;
        this.quantity = quantity;
    }
}
