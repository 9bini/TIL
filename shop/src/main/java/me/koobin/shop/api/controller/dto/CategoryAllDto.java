package me.koobin.shop.api.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import me.koobin.shop.domain.category.Category;

/**
 * @author gutaegyun
 */
@Data
public class CategoryAllDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryAllDto> children;

    @Builder
    public CategoryAllDto(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = new ArrayList<>();
    }

    public static CategoryAllDto of(Category category) {
        return CategoryAllDto.builder()
                .id(category.getId())
                .name(category.getName())
                .parentId(category.getParent() != null ?category.getParent().getId():null)
                .build();
    }
}
