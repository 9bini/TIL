package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;
import me.koobin.shop.domain.Category;


@Data
public class CategoryFindDto {
    private Long id;
    private String name;
    private Long parent;

    @Builder
    public CategoryFindDto(Long id, String name, Long parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public static CategoryFindDto of(Category category) {
        return CategoryFindDto.builder()
                .id(category.getId())
                .name(category.getName())
                .parent(category.getParent() != null ? category.getParent().getId() : null)
                .build();
    }
}
