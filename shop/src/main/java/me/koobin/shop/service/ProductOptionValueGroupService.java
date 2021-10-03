package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.ProductOptionValueDto;
import me.koobin.shop.domain.productoptionvalue.ProductOptionValue;
import me.koobin.shop.domain.productoptionvaluegroup.ProductOptionValueGroup;
import me.koobin.shop.domain.productoptionvaluegroup.ProductOptionValueGroupRepository;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionValueGroupService {

  private final ProductOptionValueGroupRepository repository;

  public void insertProductOptionValueGroup(
      ProductOptionValueGroupOption productOptionValueGroupOption,
      ProductOptionValueDto productOptionValueDto) {
    ProductOptionValue productOptionValue = productOptionValueDto.getProductOptionValue();
    repository.save(new ProductOptionValueGroup(productOptionValue,
        productOptionValueGroupOption));
  }
}
