package me.koobin.shop.api.controller.dto;

import lombok.Data;
import me.koobin.shop.domain.FitType;
import me.koobin.shop.domain.Gender;

@Data
public class ModelSizeInfoDto {
    private Gender gender;
    private Float height;
    private Float weight;
    private String wearingSize;
    private FitType fitType;
}
