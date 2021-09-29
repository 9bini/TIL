package me.koobin.shop.api.controller.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data @AllArgsConstructor @Builder
public class CategoryUpdateDto{
    private Long id;
    @NotBlank
    private String name;
    private Long parentId;
}
