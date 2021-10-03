package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.brand.Brand;

/**
 * @author gutaegyun
 */
@NoArgsConstructor
@Data
public class BrandFindDto {

    private Long brandId;
    private String name;

    @Builder
    public BrandFindDto(Long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public static BrandFindDto of(Brand brand){
        return BrandFindDto
                .builder()
                .brandId(brand.getId())
                .name(brand.getName())
                .build();

    }
}
