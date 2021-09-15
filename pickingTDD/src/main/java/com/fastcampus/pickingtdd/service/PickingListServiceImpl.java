package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PickingListServiceImpl implements PickingListService{

    @Autowired
    OrderService orderService;

    @Override
    public PickingList makePickingList(Order order) {
        PickingList pickingList = new PickingList();
        pickingList.setOrderId(order.getOrderId());
        pickingList.setState("NOTASSINGED");
        Map<Sku,Integer> skuAmountMap = new HashMap<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            skuAmountMap.put(orderDetail.getSku(),orderDetail.getAmount());
        }
        pickingList.setSkuAmountMap(skuAmountMap);

        orderService.changeOrderState(order, OrderStateEnum.LISTMADED);

        return pickingList;
    }
}
