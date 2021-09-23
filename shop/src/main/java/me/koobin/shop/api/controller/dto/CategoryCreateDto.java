package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class CategoryCreateDto {
    @NotBlank
    private String name;
    private Long parentId;
}
