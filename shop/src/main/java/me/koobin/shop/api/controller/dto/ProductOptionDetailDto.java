package me.koobin.shop.api.controller.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.SalesStatus;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class ProductOptionDetailDto {

    @Builder.Default
    private List<Long> productOptionValueSequences = new ArrayList<>();

    private Long optionAdditionalPrice;
    private Long maxPurchaseQuantity;
    @NotNull(message = "최대 구매수량 제한없음은 필수 입니다.")
    private Boolean maxUnlimited;
    private SalesStatus salesStatus;

    @NotNull(message = "수량 한정여부는 필수 입니다.")
    private Boolean quantityUnlimited;
    private Long quantity;
}
