package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.domain.product.Product;
import me.koobin.shop.domain.productsize.ProductSize;
import me.koobin.shop.domain.productsize.SizeType;
import me.koobin.shop.domain.productsize.ProductSizeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SizeService {
  private final ProductSizeRepository productSizeRepository;
  public void insertSizes(CreateProductDTO createProductDTO, Product product) {
    for (SizeType sizeType : createProductDTO.getSizeTypes()) {
      ProductSize productSize = new ProductSize(product, sizeType);
      productSizeRepository.save(productSize);
    }
  }
}
