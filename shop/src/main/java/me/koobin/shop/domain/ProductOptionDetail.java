package me.koobin.shop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
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

    @OneToOne
    @JoinColumn(name = "FILE_INFO_ID")
    private FileInfo fileInfo;

}
