package me.koobin.shop.api.controller.dto;

import java.util.List;
import lombok.Data;

@Data
public class OptionDTO {
    private Long index;
    private String optionName;
    private List<OptionValueDTO> optionValueDTOs;
    private Boolean require;
}
