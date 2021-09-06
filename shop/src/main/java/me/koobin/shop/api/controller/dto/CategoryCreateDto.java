package me.koobin.shop.api.controller.dto;

import lombok.Data;

@Data
public class CategoryCreateDto {
    private String name;
    private Long parent;
    private Long sort;
    private Float sellingCommission;
}
