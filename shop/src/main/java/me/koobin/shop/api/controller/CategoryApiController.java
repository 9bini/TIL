package me.koobin.shop.api.controller;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.response.ApiResponseDto;
import me.koobin.shop.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/v1")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ApiResponseDto<CategoryFindDto> findById(@PathVariable Long id){
        return ApiResponseDto.OK(categoryService.findById(id));
    }

    @GetMapping
    public ApiResponseDto<List<CategoryFindDto>> findAll(){
        return ApiResponseDto.OK(categoryService.findAll());
    }

    @PostMapping
    public ApiResponseDto<CategoryFindDto> create(@RequestBody CategoryCreateDto categoryCreateDto){
        return ApiResponseDto.OK(categoryService.create(categoryCreateDto));
    }

    @PutMapping
    public ApiResponseDto<CategoryFindDto> update(@RequestBody CategoryUpdateDto categoryUpdateDto){
        return ApiResponseDto.OK(categoryService.update(categoryUpdateDto));
    }
}
