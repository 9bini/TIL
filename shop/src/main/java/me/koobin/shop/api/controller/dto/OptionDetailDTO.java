package me.koobin.shop.api.controller.dto;

import me.koobin.shop.domain.SalesStatus;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class OptionDetailDTO {
    private Map<Long, Long> index;
    private Long optionAdditionalPrice;
    private Long maxPurchaseQuantity;
    @NotNull(message = "최대 구매수량 제한없음은 필수 입니다.")
    private Boolean maxUnlimited;
    private SalesStatus salesStatus;

    @NotNull(message = "수량 한정여부는 필수 입니다.")
    private Boolean quantityUnlimited;
    private Long quantity;
}
