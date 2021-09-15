package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.OrderDetail;
import com.fastcampus.pickingtdd.entity.OrderStateEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailService orderDetailService;

    @Override
    public Order makeOrder(Order order) throws Exception {
        if (orderMakeValidation(order)) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                try {
                    orderDetailService.makeOrderDetail(orderDetail);
                }catch (Exception e){
                    throw e;
                }

            }
            return order;
        }
        else throw new Exception("order validation fail");

    }

    @Override
    public void changeOrderState(Order order, OrderStateEnum state) {
        order.setState(state);
    }


    private boolean orderMakeValidation(Order order) {
        if (order.getOrderId() == null
                || order.getState() == null
                || (order.getOrderDetails() == null || order.getOrderDetails().size() < 1)
        )return false;

        return true;
    }
}
