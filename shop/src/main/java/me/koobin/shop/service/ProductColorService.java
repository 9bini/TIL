package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.domain.ColorType;
import me.koobin.shop.domain.Product;
import me.koobin.shop.domain.ProductColor;
import me.koobin.shop.domain.ProductColorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ProductColorService {

  private final ProductColorRepository productColorRepository;

  public void insertProductColors(CreateProductDTO createProductDTO, Product product) {
    for (ColorType colorType : createProductDTO.getColorTypes()) {
      ProductColor productColor = new ProductColor(colorType, product);
      productColorRepository.save(productColor);
    }
  }

}
