package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PickingServiceTest {

    @Autowired
    PickingService pickingService;

    Order order;
    OrderDetail orderDetail;
    OrderDetail orderDetail2;
    PickingList pickingList;
    Picker picker;


    @BeforeEach
    void init(){
        orderDetail = new OrderDetail();
        orderDetail.setId(1L);
        orderDetail.setOrderId(1L);
        orderDetail.setSku(new Sku());
        orderDetail.setAmount(10);

        orderDetail2 = new OrderDetail();
        orderDetail2.setId(2L);
        orderDetail2.setOrderId(1L);
        orderDetail2.setSku(new Sku());
        orderDetail2.setAmount(10);

        order = new Order();
        order.setOrderId(1L);
        order.setState(OrderStateEnum.ASSIGNED);
        order.setOrderDetails(List.of(orderDetail, orderDetail2));

        pickingList = new PickingList();
        pickingList.setOrder(order);
        pickingList.setState(PickingStateEnum.ASSIGNED);
        pickingList.setId(1L);
        pickingList.setSkuAmountMap(Maps.newHashMap(orderDetail.getSku(), orderDetail.getAmount()));
        pickingList.getSkuAmountMap().put(orderDetail2.getSku(), orderDetail2.getAmount());

        pickingList.setPickedMap(Maps.newHashMap(orderDetail.getSku(), 0));
        pickingList.getSkuAmountMap().put(orderDetail2.getSku(), 0);

        picker = new Picker();
        picker.setId(1L);
        picker.setAssignedPickList(pickingList);
        picker.setAssignedOrder(order);

        pickingList.setPicker(picker);




    }

    @Test
    void picking(){
        pickingService.pick(pickingList, orderDetail.getSku());
        Assertions.assertEquals(PickingStateEnum.PROGRESS, pickingList.getState());
        Assertions.assertEquals(PickerStateEnum.ASSIGNED, picker.getState());
        Assertions.assertEquals(1, pickingList.getPickedMap().get(orderDetail.getSku()));
    }
}
