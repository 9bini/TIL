package me.koobin.shop.api.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.BrandCreateDto;
import me.koobin.shop.api.controller.dto.BrandFindDto;
import me.koobin.shop.response.ApiResponseDto;
import me.koobin.shop.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gutaegyun
 */
@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandApiController {

    private final BrandService brandService;

    @GetMapping("/{brandId}")
    public ApiResponseDto<BrandFindDto> get(@PathVariable Long brandId) {
        return ApiResponseDto.OK(brandService.getBrand(brandId));
    }

    @PostMapping
    public ApiResponseDto<BrandCreateDto> post(@RequestBody BrandCreateDto brandCreateDto){
        return ApiResponseDto.OK(brandService.insert(brandCreateDto));

    }

    @GetMapping
    public ApiResponseDto<List<BrandFindDto>> getAll() {
        return ApiResponseDto.OK(brandService.getAll());
    }
}
