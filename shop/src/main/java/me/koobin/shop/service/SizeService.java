package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.domain.Product;
import me.koobin.shop.domain.ProductSize;
import me.koobin.shop.domain.Size;
import me.koobin.shop.domain.SizeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SizeService {
  private final SizeRepository sizeRepository;
  public void insertSizes(CreateProductDTO createProductDTO, Product product) {
    for (Size size : createProductDTO.getSizes()) {
      ProductSize productSize = new ProductSize(product, size);
      sizeRepository.save(productSize);
    }
  }
}
