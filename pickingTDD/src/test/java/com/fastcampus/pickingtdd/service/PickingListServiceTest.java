package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.*;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// @SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PickingListServiceTest {

    @InjectMocks
    PickingListService pickingListService = new PickingListServiceImpl();

    @Mock
    OrderService orderService;

    @Spy
    PickerService pickerService = new PickerServiceImpl();

    Order order;

    @BeforeEach
    public void init() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1L);

        order = new Order();
        order.setOrderId(1L);
        order.setState(OrderStateEnum.ORDERED);
        order.setOrderDetails(List.of(orderDetail));
    }

    @Test
    void make() {
        // mock

        PickingList assertPickings = new PickingList();
        assertPickings.setOrder(order);
        assertPickings.setSkuAmountMap(
                Maps.newHashMap(
                        order.getOrderDetails().get(0).getSku(),
                        order.getOrderDetails().get(0).getAmount()));
        assertPickings.setState(PickingStateEnum.NOT_ASSIGNED);
        assertPickings.setPicker(null);

        PickingList make = pickingListService.makePickingList(order);

        assertEquals(1L, make.getOrder().getOrderId());
        assertEquals(PickingStateEnum.NOT_ASSIGNED, make.getState());
        assertEquals(assertPickings.getSkuAmountMap().get(order.getOrderDetails().get(0).getSku()),
                make.getSkuAmountMap().get(order.getOrderDetails().get(0).getSku()));
    }

    @Test
    void assignPicker() {
        PickingList pickingList = this.pickingListService.makePickingList(order);
        Picker picker = new Picker();

        PickingList assignPickingList = pickingListService.assignPicker(pickingList, picker);

        assertEquals(picker, assignPickingList.getPicker());
        assertEquals(PickingStateEnum.ASSIGNED, assignPickingList.getState());
        assertNotNull(assignPickingList.getPicker().getAssignedPickList());
    }

}
