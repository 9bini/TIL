package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class CategoryCreateDto {
    @NotBlank
    private String name;
    // TODO 부모 변수명 변경
    private Long parentId;
}
