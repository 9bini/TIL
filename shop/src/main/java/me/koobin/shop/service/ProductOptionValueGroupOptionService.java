package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ProductOptionDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueGroupOptionDto;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOption;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionValueGroupOptionService {

  private final ProductOptionValueGroupOptionRepository repository;
  private final ProductOptionValueGroupService productOptionValueGroupService;

  public void processProductOptionValueGroupOption(CreateProductDTO createProductDTO) {
    for (ProductOptionValueGroupOptionDto productOptionValueGroupOptionDto : createProductDTO.getProductOptionValueGroupOptionDtos()) {
      ProductOptionValueGroupOption productOptionValueGroupOption = insertProductOptionValueGroupOption(
          productOptionValueGroupOptionDto);
      processProductOptionValueGroup(createProductDTO, productOptionValueGroupOptionDto,
          productOptionValueGroupOption);
    }
  }

  private ProductOptionValueGroupOption insertProductOptionValueGroupOption(
      ProductOptionValueGroupOptionDto productOptionValueGroupOptionDto) {
    return repository.save(
        ProductOptionValueGroupOption.builder()
            .optionAdditionalPrice(productOptionValueGroupOptionDto.getOptionAdditionalPrice())
            .maxPurchaseQuantity(productOptionValueGroupOptionDto.getMaxPurchaseQuantity())
            .salesStatus(productOptionValueGroupOptionDto.getSalesStatus())
            .quantityUnlimited(productOptionValueGroupOptionDto.getQuantityUnlimited())
            .quantity(productOptionValueGroupOptionDto.getQuantity())
            .build());
  }

  private void processProductOptionValueGroup(CreateProductDTO createProductDTO,
      ProductOptionValueGroupOptionDto productOptionValueGroupOptionDto,
      ProductOptionValueGroupOption productOptionValueGroupOption) {
    for (Long productOptionValueSequence : productOptionValueGroupOptionDto.getProductOptionValueSequences()) {
      for (ProductOptionDto productOptionDto : createProductDTO.getProductOptionDtos()) {
        for (ProductOptionValueDto productOptionValueDto : productOptionDto.getProductOptionValueDtos()) {
          if (productOptionValueSequence.equals(productOptionValueDto.getSequence())) {
            productOptionValueGroupService.insertProductOptionValueGroup(
                productOptionValueGroupOption, productOptionValueDto);
            break;
          }
        }
      }
    }
  }


}
