package com.fastcampus.pickingtdd.service;


import com.fastcampus.pickingtdd.entity.Order;

public interface OrderService {
    Order makeOrder(Order order) throws Exception;
}
