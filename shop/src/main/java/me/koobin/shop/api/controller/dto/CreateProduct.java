package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.Gender;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor @Builder
public class CreateProduct {
    @NotNull(message = "카테고리는 필수 입니다.")
    private Long categoryId;

    @NotNull(message = "성별은 필수 입니다.")
    private Gender gender;

    @Max(value = 100)
    @NotNull(message = "노출 상품명은 필수 입니다.")
    private String exposedProductName;

    @Max(value = 100)
    @NotNull(message = "업체상품명은 필수 입니다.")
    private String productName;

    private String additionalText;

    @NotNull(message = "브랜드는 필수 입니다.")
    private Long brand;


}
