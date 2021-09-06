package me.koobin.shop.api.controller;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController("/category/v1")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public void findById(@PathVariable Long id){
        categoryService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryCreateDto categoryCreateDto){
        categoryService.create(categoryCreateDto);
    }
}
