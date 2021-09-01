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
    // TODO 핏 타입을 IdentificationCode 으로 변환하기
    private FitType fitType;
}
