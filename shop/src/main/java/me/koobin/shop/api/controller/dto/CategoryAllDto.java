package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;
import me.koobin.shop.domain.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gutaegyun
 */
@Data
public class CategoryAllDto {
    private Long id;
    private String name;
    private List<CategoryAllDto> children;

    @Builder
    public CategoryAllDto(Long id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public static CategoryAllDto of(Category category) {
        return CategoryAllDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
