package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;
import me.koobin.shop.domain.modelsize.FitType;
import me.koobin.shop.domain.modelsize.Gender;

@Data @Builder
public class ModelSizeInfoDto {
    private Gender gender;
    private Float height;// cm
    private Float weight; // kg
    private String wearingSize; //착용 사이즈
    private FitType fitType;
}
