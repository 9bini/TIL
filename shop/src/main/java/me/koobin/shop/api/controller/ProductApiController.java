package me.koobin.shop.api.controller;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/v1/")
public class ProductApiController {
    private final ProductService productService;

    @PostMapping
    public String register(CreateProductDTO createProductDTO){
        productService.newProduct(createProductDTO);
        return "";
    }
}
