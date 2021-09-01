package me.koobin.shop.api.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class OptionDTO {
    private Long index;
    private String optionName;
    private List<OptionValueDTO> optionValueDTOs;
    private Boolean require;
}
