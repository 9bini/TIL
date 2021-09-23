package me.koobin.shop.service;

import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// @DisplayName("카테고리 서비스 테스트 케이스")
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 테스트 순서를 제공하는 기능
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
@Transactional
class CategoryServiceTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    Validator validator;

    @BeforeEach
    void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    void create_success() {
        CategoryCreateDto categoryCreateDto = getCategory("카테고리 이름", null);
        CategoryFindDto categoryFindDto = categoryService.create(categoryCreateDto);
        try {
            Category category = categoryRepository.findById(categoryFindDto.getId()).orElseThrow(IllegalArgumentException::new);
            assertEquals(categoryFindDto.getId(), category.getId());
        } catch (IllegalArgumentException e) {
            fail("should not throw exception");
        }
    }

    @Test
    void create_add_parent_success() {
        CategoryCreateDto parentDto = getCategory("카테고리 이름", null);
        CategoryFindDto parent = categoryService.create(parentDto);
        parentDto.setParentId(parent.getId());

        CategoryFindDto child = categoryService.create(parentDto);

        Category category = categoryRepository.findById(child.getId()).orElseThrow(IllegalArgumentException::new);
        assertEquals(child.getParent(), category.getParent().getId());

    }


    @Test
    void update_success() {
        CategoryCreateDto categoryCreateDto = getCategory("카테고리 이름", null);
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
    void update_id_not_found_fail() {
        CategoryCreateDto categoryCreateDto = getCategory("카테고리 이름", null);
        CategoryFindDto categoryFindDto = categoryService.create(categoryCreateDto);
        CategoryUpdateDto updateDto = CategoryUpdateDto.builder()
                .id(-1L)
                .name("수정된 카테고림 이름")
                .parentId(categoryFindDto.getParent())
                .build();

        assertThrows(IllegalArgumentException.class, () -> categoryService.update(updateDto));
    }

    @Test
    void getChild_success() {
        CategoryFindDto parent1 = categoryService.create(getCategory("부모 카테고리 1", null));
        CategoryFindDto parent2 = categoryService.create(getCategory("부모 카테고리 2", null));
        int expectedSize = 10;
        for (int i = 0; i < expectedSize; i++)
            categoryService.create(getCategory("부모1의 자식 " + (i + 1), parent1.getId()));

        for (int i = 0; i < expectedSize; i++)
            categoryService.create(getCategory("부모2의 자식 " + (i + 1), parent2.getId()));

        List<CategoryFindDto> child = categoryService.getChildren(parent1.getId());
        assertEquals(expectedSize, child.size());
    }

    @Test
    void getChild_size_0_success() {
        CategoryFindDto parent1 = categoryService.create(getCategory("부모 카테고리 1", null));
        for (int i = 0; i < 10; i++)
            categoryService.create(getCategory("부모1의 자식 " + (i + 1), parent1.getId()));
        List<CategoryFindDto> child = categoryService.getChildren(-1L);
        assertEquals(0, child.size());
    }


    @Test
    void getChild_parent_isnull_success() {
        int expectedSize = 2;
        for (int i = 0; i < expectedSize; i++) categoryService.create(getCategory("카테고리" + (i + 1), null));

        List<CategoryFindDto> child = categoryService.getChildren(null);
        assertEquals(expectedSize, child.size());
    }


    private CategoryCreateDto getCategory(String s, Long o) {
        return new CategoryCreateDto(s, o);
    }

}