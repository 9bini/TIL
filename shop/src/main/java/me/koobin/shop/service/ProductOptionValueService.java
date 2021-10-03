package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.ProductOptionDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueDto;
import me.koobin.shop.domain.productoptionvalue.ProductOptionValue;
import me.koobin.shop.domain.productoptionvalue.ProductOptionValueRepository;
import me.koobin.shop.domain.productoption.ProductOption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionValueService {

  private final ProductOptionValueRepository productOptionValueRepository;


  public void saveNewProductOptionValues(ProductOptionDto productOptionDto,
      ProductOption productOption) {
    for (ProductOptionValueDto productOptionValueDto : productOptionDto.getProductOptionValueDtos()) {
      ProductOptionValue productOptionValue = saveNewProductOptionValue(productOption,
          productOptionValueDto);
      productOptionValueDto.setProductOptionValue(productOptionValue);
    }
  }

  private ProductOptionValue saveNewProductOptionValue(ProductOption productOption,
      ProductOptionValueDto productOptionValueDto) {

    Long additionalAmount = productOptionValueDto.getAdditionalAmount();
    String valueName = productOptionValueDto.getValueName();
    Long supplyPrice = productOptionValueDto.getSupplyPrice();

    return productOptionValueRepository.save(
        ProductOptionValue.builder()
            .productOption(productOption)
            .additionalAmount(additionalAmount)
            .valueName(valueName)
            .supplyPrice(supplyPrice)
            .build()
    );
  }
}
