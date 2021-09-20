package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data @AllArgsConstructor @Builder
public class CategoryUpdateDto{
    private Long id;
    @NotBlank
    private String name;
    private Long parentId;
}
