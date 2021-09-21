package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryFindDto findById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(NotFoundException::new);
        return CategoryFindDto.of(category);
    }

    public CategoryFindDto create(CategoryCreateDto categoryCreateDto) {
        Long parentId = categoryCreateDto.getParentId();
        Category category = Category.builder()
                .name(categoryCreateDto.getName())
                .parent(getParent(parentId))
                .build();
        return CategoryFindDto.of(categoryRepository.save(category));
    }

    private Category getParent(Long parentId) {
        if (parentId == null)return null;
        return categoryRepository.findById(parentId).orElseThrow(NotFoundException::new);
    }

    public CategoryFindDto update(CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow(NotFoundException::new);
        Category parent = getParent(categoryUpdateDto.getParentId());

        category.update(categoryUpdateDto.getName(), parent);

        return CategoryFindDto.of(category);
    }

    public List<CategoryFindDto> findAll() {
        return  categoryRepository.findAll()
                .stream()
                .map(CategoryFindDto::of)
                .collect(Collectors.toList());

    }
}
