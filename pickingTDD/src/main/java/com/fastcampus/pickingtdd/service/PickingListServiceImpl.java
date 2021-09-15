package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Service
public class PickingListServiceImpl implements PickingListService{

    @Autowired
    OrderService orderService;

    @Autowired
    PickerService pickerService;

    @Override
    public PickingList makePickingList(Order order) {
        PickingList pickingList = new PickingList();
        pickingList.setOrder(order);
        pickingList.setState(PickingStateEnum.NOT_ASSIGNED);
        Map<Sku,Integer> skuAmountMap = new HashMap<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            skuAmountMap.put(orderDetail.getSku(),orderDetail.getAmount());
        }
        pickingList.setSkuAmountMap(skuAmountMap);

        orderService.changeOrderState(order, OrderStateEnum.LISTMADED);

        return pickingList;
    }

    @Override
    public PickingList assignPicker(PickingList pickingList, Picker picker) {
        pickingList.setPicker(picker);
        pickingList.setState(PickingStateEnum.ASSIGNED);

        if (picker.getAssignedPickList() == null || !picker.getAssignedPickList().equals(pickingList)){
            pickerService.assignPickingList(picker, pickingList);
        }

        orderService.changeOrderState(pickingList.getOrder(), OrderStateEnum.ASSIGNED);
        return pickingList;
    }


}
