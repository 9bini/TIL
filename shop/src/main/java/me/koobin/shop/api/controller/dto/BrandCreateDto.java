package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gutaegyun
 */
@AllArgsConstructor @NoArgsConstructor
@Data
public class BrandCreateDto {
    private Long id;
    private String name;
}
