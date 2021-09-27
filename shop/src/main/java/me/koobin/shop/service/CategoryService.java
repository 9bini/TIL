package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryAllDto;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
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
        if (parentId == null) return null;
        return categoryRepository.findById(parentId).orElseThrow(IllegalArgumentException::new);
    }

    public CategoryFindDto update(CategoryUpdateDto categoryUpdateDto) {
        Category category = categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow(IllegalArgumentException::new);
        Category parent = getParent(categoryUpdateDto.getParentId());

        category.update(categoryUpdateDto.getName(), parent);

        return CategoryFindDto.of(category);
    }

    public List<CategoryFindDto> getDirectChildren(Long parentID) {
        List<Category> children = categoryRepository.findById(parentID)
                .orElseThrow(IllegalArgumentException::new)
                .getChildren();
        return children.stream().map(CategoryFindDto::of).collect(Collectors.toList());
    }

    public List<CategoryAllDto> getAll() {

        List<CategoryAllDto> result = new ArrayList<>(); // 결과 값

        // 레벨 1 카테고리들을 Q에 삽입
        Queue<Category> targetQ = new LinkedList<>(categoryRepository.findByParentIsNull());
        // 부모를 붙여 넣는 용도
        Queue<CategoryAllDto> pasteParent = new LinkedList<>();

        while (!targetQ.isEmpty()) {// Q가 빌때 까지 반복
            Category target = targetQ.poll();
            CategoryAllDto targetDto = getTargetDto(pasteParent, CategoryAllDto.of(target))
                    .orElseThrow(IllegalArgumentException::new);

            if (target.getParent() == null) result.add(targetDto);

            for (Category child : target.getChildren()) {
                targetQ.add(child);
                CategoryAllDto childDto = CategoryAllDto.of(child);
                targetDto.getChildren().add(childDto);
                pasteParent.add(childDto);

            }
        }


        return result;
    }

    private Optional<CategoryAllDto> getTargetDto(Queue<CategoryAllDto> pasteParent, CategoryAllDto target) {
        return Optional.ofNullable(target.getParentId() == null ?  target: pasteParent.poll());
    }


    public String getCurrentPath(Long currentCategoryId) {
        Category category = categoryRepository.findById(currentCategoryId).orElseThrow(IllegalArgumentException::new);
        StringBuilder result = new StringBuilder();
        while (category != null) {
            result.insert(0, category.getName() + " > ");
            category = category.getParent();
        }
        result.delete(result.length()-3, result.length());
        return result.toString();
    }
}
