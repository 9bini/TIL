package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public OrderDetail makeOrderDetail(OrderDetail orderDetail) throws Exception {
        if (!validation(orderDetail)) throw new Exception("orderDetail validation fail");
        return orderDetail;
    }

    private boolean validation(OrderDetail orderDetail) {
        if (orderDetail.getId() == null
                || orderDetail.getOrderId() == null
                || orderDetail.getSku() == null) return false;
        return true;
    }
}
