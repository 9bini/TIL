package me.koobin.shop.service;

import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.domain.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


// @DisplayName("카테고리 서비스 테스트 케이스")
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 테스트 순서를 제공하는 기능
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @Test
    void create() {
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto("카테고리 이름", null);
        CategoryFindDto categoryFindDto = categoryService.create(categoryCreateDto);
        try {
            categoryRepository.findById(categoryFindDto.getId()).orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            fail("should not throw exception");
        }
    }


    @Test
    void update() {
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto("카테고리 이름", null);
        CategoryFindDto categoryFindDto = categoryService.create(categoryCreateDto);

        CategoryFindDto update = categoryService.update(CategoryUpdateDto.builder()
                        .id(categoryFindDto.getId())
                        .name("수정된 카테고림 이름")
                        .parentId(categoryFindDto.getParent())
                .build());

        assertEquals(categoryFindDto.getId(), update.getId());
        assertEquals("수정된 카테고림 이름", update.getName());
    }

    @Test
    void test(){

    }
}