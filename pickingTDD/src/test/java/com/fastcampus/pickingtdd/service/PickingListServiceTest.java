package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.OrderDetail;
import com.fastcampus.pickingtdd.entity.OrderStateEnum;
import com.fastcampus.pickingtdd.entity.PickingList;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PickingListServiceTest {

    @InjectMocks
    PickingListService pickingListService= new PickingListServiceImpl();

    @Mock
    OrderService orderService;

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
    public void make() {
        // mock

        PickingList assertPickings = new PickingList();
        assertPickings.setOrderId(1L);
        assertPickings.setSkuAmountMap(
                Maps.newHashMap(
                        order.getOrderDetails().get(0).getSku(),
                        order.getOrderDetails().get(0).getAmount()));
        assertPickings.setState("NOTASSINGED");
        assertPickings.setPicker(null);

        PickingList make = pickingListService.makePickingList(order);

        Assertions.assertEquals(1L, make.getOrderId());
        Assertions.assertEquals("NOTASSINGED", make.getState());
        Assertions.assertEquals(assertPickings.getSkuAmountMap().get(order.getOrderDetails().get(0).getSku()),
                make.getSkuAmountMap().get(order.getOrderDetails().get(0).getSku()));
    }
}
