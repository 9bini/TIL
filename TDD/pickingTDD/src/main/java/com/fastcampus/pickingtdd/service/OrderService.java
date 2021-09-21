package com.fastcampus.pickingtdd.service;


import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.OrderStateEnum;

public interface OrderService {
    Order makeOrder(Order order) throws Exception;

    void changeOrderState(Order order, OrderStateEnum state);
}
