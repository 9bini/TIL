package me.koobin.shop.api.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @AllArgsConstructor
@Data @NoArgsConstructor
public class ProductOptionDto {
    private String optionName;
    @Builder.Default
    private List<ProductOptionValueDto> productOptionValueDtos = new ArrayList<>();
    private Boolean require;
    private Long entityId;
}
