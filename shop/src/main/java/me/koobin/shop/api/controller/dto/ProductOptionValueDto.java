package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gutaegyun
 */
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class ProductOptionValueDto {
  private Long sequence;
  private String valueName;
  private Long additionalAmount;
  private Long supplyPrice;
  private Long entityId;
}
