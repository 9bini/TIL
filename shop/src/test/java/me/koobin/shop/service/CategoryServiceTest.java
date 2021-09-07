package me.koobin.shop.service;

import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.embedded.BaseTimeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


// @DisplayName("카테고리 서비스 테스트 케이스")
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 테스트 순서를 제공하는 기능
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;


    @InjectMocks
    private CategoryService categoryService;
    
    @Test
    void createCategory() {

        // given
        CategoryCreateDto requestDto = new CategoryCreateDto("카테고리", null, null, 0F);
        LocalDateTime now = LocalDateTime.now();
        BaseTimeEntity baseTimeEntity = new BaseTimeEntity(now, now);
        Category insertCategory = Category.builder()
                .disabled(false)
                .sort(null)
                .parent(null)
                .name("카테고리")
                .sellingCommission(0F)
                .baseTimeEntity(baseTimeEntity)
                .build();
        Category returnCategory = Category.builder()
                .id(1L)
                .disabled(false)
                .sort(null)
                .parent(null)
                .name("카테고리")
                .sellingCommission(0F)
                .baseTimeEntity(baseTimeEntity)
                .build();
        given(categoryRepository.save(insertCategory)).willReturn(returnCategory);

        //Category save = categoryRepository.save(insertCategory);
        Category category = categoryService.create(requestDto);
        /*
        //when(categoryRepository.findById(category.getId()).orElseThrow(IllegalArgumentException::new)).thenReturn(cateOgory);
        Category findBy = categoryRepository.findById(category.getId()).orElseThrow(IllegalArgumentException::new);
        Assertions.assertEquals(category, findBy);*/

    }
    // 테스트 하는 이유가 머지?
    // 해당 로직이 내가 원하는 결과를 나오지는 확인 하는 절차다
    // repository 기본 결과를 검드

}