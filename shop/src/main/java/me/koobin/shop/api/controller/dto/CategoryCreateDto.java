package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryCreateDto {
    private String name;
    private Long parent;
    private Long sort;
    private Float sellingCommission;
}
