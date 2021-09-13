package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.OrderStateEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    Order orderSuccess;
    Order orderFail;

    @BeforeEach
    void orderInit(){
        orderSuccess = new Order();
        orderSuccess.setOrderId(1L);
        orderSuccess.setState(OrderStateEnum.ORDERED);

        orderFail = new Order();
        orderFail.setOrderId(null);
        orderFail.setState(OrderStateEnum.ORDERED);
    }


    @Test
    void testOrderMake_success(){


        Order orderResponse = null;
        try {
            orderResponse = orderService.makeOrder(orderSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }
        Assertions.assertEquals(1L, orderResponse.getOrderId());
        Assertions.assertEquals(OrderStateEnum.ORDERED, orderResponse.getState());

    }

    @Test
    void testOrderValidation_success(){
        Order orderResponse = null;
        try {
            orderResponse = orderService.makeOrder(orderSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }

        Assertions.assertEquals(1L, orderResponse.getOrderId());
        Assertions.assertEquals(OrderStateEnum.ORDERED, orderResponse.getState());
    }

    @Test
    void testOrderValidation_fail(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            orderService.makeOrder(orderFail);
        });
        Assertions.assertEquals("order validation fail", exception.getMessage());
    }
}
