package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
    void init() {
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
        pickingList.getPickedMap().put(orderDetail2.getSku(), 0);

        picker = new Picker();
        picker.setId(1L);
        picker.setAssignedPickList(pickingList);
        picker.setAssignedOrder(order);

        pickingList.setPicker(picker);


    }

    @Test
    void picking_one_success() {
        try {
            pickingService.pick(pickingList, orderDetail.getSku());
        } catch (Exception e) {
            fail("should not exception");
        }

        assertEquals(PickingStateEnum.PROGRESS, pickingList.getState());
        assertEquals(PickerStateEnum.PROCESS, picker.getState());
        assertEquals(1, pickingList.getPickedMap().get(orderDetail.getSku()));
    }

    @Test
    void pick_DOEN_Success() {
        try {
            for (int i = 0; i < 10; i++) {
                pickingService.pick(pickingList, orderDetail.getSku());
                pickingService.pick(pickingList, orderDetail2.getSku());
            }
        } catch (Exception e) {
            fail("should not exception");
        }

        assertEquals(PickingStateEnum.DONE, pickingList.getState());
        assertEquals(PickerStateEnum.DONE, pickingList.getPicker().getState());
    }

    @Test
    void pick_Much() {
        try {
            for (int i = 0; i < 12; i++) {
                pickingService.pick(pickingList, orderDetail.getSku());
            }
        } catch (Exception e) {
            assertEquals("to much sku", e.getMessage());
        }
    }
}
