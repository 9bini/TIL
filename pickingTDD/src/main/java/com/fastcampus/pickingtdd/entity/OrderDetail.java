package com.fastcampus.pickingtdd.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDetail {
    private Long id;
    private Long orderId;
    private Sku sku;
    private int amount;
}
