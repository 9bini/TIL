package me.koobin.shop.domain.productoptionvaluegroupoption;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.SalesStatus;

@Entity @NoArgsConstructor
public class ProductOptionValueGroupOption {
    @Id
    @GeneratedValue
    private Long id;

    private Long optionAdditionalPrice; // 추가금액
    private Long maxPurchaseQuantity; //
    @NotNull(message = "최대 구매수량 제한없음은 필수 입니다.")
    private Boolean maxUnlimited;
    private SalesStatus salesStatus;

    @NotNull(message = "수량 한정여부는 필수 입니다.")
    private Boolean quantityUnlimited;
    private Long quantity;

    @Builder
    public ProductOptionValueGroupOption(Long optionAdditionalPrice, Long maxPurchaseQuantity,
        Boolean maxUnlimited, SalesStatus salesStatus, Boolean quantityUnlimited,
        Long quantity) {
        this.optionAdditionalPrice = optionAdditionalPrice;
        this.maxPurchaseQuantity = maxPurchaseQuantity;
        this.maxUnlimited = maxUnlimited;
        this.salesStatus = salesStatus;
        this.quantityUnlimited = quantityUnlimited;
        this.quantity = quantity;
    }
}
