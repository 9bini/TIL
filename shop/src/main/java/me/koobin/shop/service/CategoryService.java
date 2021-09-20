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

    public CategoryFindDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(NotFoundException::new);
        return CategoryFindDto.of(category);
    }

    public CategoryFindDto create(CategoryCreateDto categoryCreateDto) {
        Long parentId = categoryCreateDto.getParent();
        Category category = Category.builder()
                .name(categoryCreateDto.getName())
                .parent(getParent(parentId))
                .build();
        Category save = categoryRepository.save(category);

        return CategoryFindDto.of(save);
    }

    private Category getParent(Long parentId) {
        Category parent = null;
        if (parentId != null) {
            parent = categoryRepository.findById(parentId).orElseThrow(NotFoundException::new);
        }
        return parent;
    }

    public CategoryFindDto update(CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow(NotFoundException::new);
        Category parent = null;
        if (categoryUpdateDto.getParentId() != null
                && !category.getParent().getId().equals(categoryUpdateDto.getParentId())) {
            parent = categoryRepository.findById(categoryUpdateDto.getParentId()).orElseThrow(NotFoundException::new);
        }
        category.update(categoryUpdateDto.getName(), parent);
        return CategoryFindDto.of(category);
    }

    public List<CategoryFindDto> findAll() {
        List<CategoryFindDto> result;
        List<Category> categories = categoryRepository.findAll();
        result = categories.stream().map(CategoryFindDto::of).collect(Collectors.toList());
        return result;
    }
}
