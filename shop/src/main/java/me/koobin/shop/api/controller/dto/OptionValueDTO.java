package me.koobin.shop.api.controller.dto;

import lombok.Data;

@Data
public class OptionValueDTO {
    private Long index;
    private String valueName;
    private Long additionalAmount;
    private Long supplyPrice;
}
