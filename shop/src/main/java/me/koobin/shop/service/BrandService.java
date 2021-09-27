package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.BrandCreateDto;
import me.koobin.shop.api.controller.dto.BrandFindDto;
import me.koobin.shop.domain.Brand;
import me.koobin.shop.domain.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gutaegyun
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandFindDto getBrand(Long brandId) {
        return BrandFindDto.of(brandRepository.findById(brandId).orElseThrow(IllegalArgumentException::new));
    }

    public BrandCreateDto insert(BrandCreateDto brandCreateDto) {
        Brand save = brandRepository.save(Brand.builder()
                .name(brandCreateDto.getName())
                .build());
        brandCreateDto.setId(save.getId());
        return brandCreateDto;
    }

    public List<BrandFindDto> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(BrandFindDto::of)
                .collect(Collectors.toList())
                ;
    }
}
