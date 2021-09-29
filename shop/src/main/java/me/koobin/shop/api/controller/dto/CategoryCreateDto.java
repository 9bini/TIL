package me.koobin.shop.api.controller.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryCreateDto {
    @NotBlank
    private String name;
    private Long parentId;
}
