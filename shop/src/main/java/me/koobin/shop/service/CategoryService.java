package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryAllDto;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryFindDto findById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
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
        return categoryRepository.findById(parentId).orElseThrow(IllegalArgumentException::new);
    }

    public CategoryFindDto update(CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow(IllegalArgumentException::new);
        Category parent = getParent(categoryUpdateDto.getParentId());

        category.update(categoryUpdateDto.getName(), parent);

        return CategoryFindDto.of(category);
    }

    public List<CategoryFindDto> getChildren(Long parentID) {
        List<Category> children = categoryRepository.findByParent_Id(parentID);
        return  children.stream().map(CategoryFindDto::of).collect(Collectors.toList());
    }

    public List<CategoryAllDto> getAll() {
        List<CategoryAllDto> result = new ArrayList<>();
        List<Category> allCategory = categoryRepository.findAll(Sort.by("parent"));

/*
        for (Category category : allCategory) {
            if (category.getParent() == null) {
                result.add(CategoryAllDto.of(category));
                continue;
            }
            for (CategoryAllDto categoryAllDto : result) {
                if(category.getParent().getId().equals(categoryAllDto.getId())){
                    categoryAllDto.getChildren().add(CategoryAllDto.of(category));
                    break;
                }
            }
        }
*/

        return result;
    }

    public String getCurrentPath(Long currentCategoryId) {
        Category category = categoryRepository.findById(currentCategoryId).orElseThrow(IllegalArgumentException::new);
        String result = "";
        while (category != null){
            result += category.getName();
            category = category.getParent();
        }

        return result;
    }
}
