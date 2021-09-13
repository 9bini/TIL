package com.fastcampus.pickingtdd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter @Setter
public class Order {
    private Long orderId;
    private OrderStateEnum state;

}
