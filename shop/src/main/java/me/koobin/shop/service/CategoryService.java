package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Category create(CategoryCreateDto categoryCreateDto) {
        Long parentId = categoryCreateDto.getParent();
        Category category = Category.builder()
                .name(categoryCreateDto.getName())
                .parent(getParent(parentId))
                .sort(categoryCreateDto.getSort())
                .sellingCommission(categoryCreateDto.getSellingCommission())
                .disabled(false)
                .build();
        return categoryRepository.save(category);
    }

    private Category getParent(Long parentId) {
        Category parent = null;
        if (parentId != null){
            parent = categoryRepository.findById(parentId).orElseThrow(IllegalArgumentException::new);
        }
        return parent;
    }
}
