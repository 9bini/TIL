package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ProductOptionDto;
import me.koobin.shop.domain.productoption.ProductOption;
import me.koobin.shop.domain.productoption.ProductOptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionService {

  private final ProductOptionRepository productOptionRepository;
  private final ProductOptionValueService productOptionValueService;

  public void saveNewProductOptions(CreateProductDTO createProductDTO) {
    for (ProductOptionDto productOptionDto : createProductDTO.getProductOptionDtos()) {
      ProductOption productOption = saveNewProductOption(
          productOptionDto);
      productOptionValueService.saveNewProductOptionValues(productOptionDto, productOption);
    }
  }

  private ProductOption saveNewProductOption(ProductOptionDto productOptionDto) {
    Boolean require = productOptionDto.getRequire();
    String optionName = productOptionDto.getOptionName();
    return productOptionRepository.save(
        ProductOption.builder()
            .requireOption(require)
            .name(optionName)
            .build());
  }
}
