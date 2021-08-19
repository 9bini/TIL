package me.koobin.shop.api.controller.dto;

import java.util.List;

public class OptionDTO {
    private Long index;
    private String optionName;
    private List<OptionValueDTO> optionValueDTOs;
    private boolean require;
}
