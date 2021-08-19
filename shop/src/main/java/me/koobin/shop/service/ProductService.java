package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.domain.BrandRepository;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.domain.ProductRepository;
import me.koobin.shop.entity.Brand;
import me.koobin.shop.entity.Category;
import me.koobin.shop.entity.Product;
import me.koobin.shop.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public void newProduct(CreateProductDTO createProductDTO) {
        Category category = categoryRepository
                .findById(createProductDTO.getCategoryId())
                .orElseThrow(NotFoundException::new);
        Brand brand = brandRepository
                .findById(createProductDTO.getBrand())
                .orElseThrow(NotFoundException::new);

        Product.newProduct();

    }
}
