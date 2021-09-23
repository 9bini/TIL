package me.koobin.shop.api.controller;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryAllDto;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.api.controller.dto.CategoryUpdateDto;
import me.koobin.shop.response.ApiResponseDto;
import me.koobin.shop.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ApiResponseDto<CategoryFindDto> create(@RequestBody @Valid CategoryCreateDto categoryCreateDto){
        return ApiResponseDto.OK(categoryService.create(categoryCreateDto));
    }

    @PutMapping
    public ApiResponseDto<CategoryFindDto> update(@RequestBody @Valid CategoryUpdateDto categoryUpdateDto){
        return ApiResponseDto.OK(categoryService.update(categoryUpdateDto));
    }

    @GetMapping("/parent/{parentID}")
    public ApiResponseDto<List<CategoryFindDto>> getChild(@PathVariable(required = false) Long parentID){
        return ApiResponseDto.OK(categoryService.getChildren(parentID));
    }

    @GetMapping
    public ApiResponseDto<List<CategoryAllDto>> getAll(){
        return ApiResponseDto.OK(categoryService.getAll());
    }
}
