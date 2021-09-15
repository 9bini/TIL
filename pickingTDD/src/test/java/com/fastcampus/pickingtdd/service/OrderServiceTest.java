package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.Order;
import com.fastcampus.pickingtdd.entity.OrderDetail;
import com.fastcampus.pickingtdd.entity.OrderStateEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

    @Mock
    OrderDetailService orderDetailService;

    Order orderSuccess;
    Order orderFail;

    @BeforeEach
    void orderInit(){
        OrderDetail orderDetail =new OrderDetail();
        orderSuccess = new Order();
        orderSuccess.setOrderId(1L);
        orderSuccess.setState(OrderStateEnum.ORDERED);
        orderSuccess.setOrderDetails(List.of(orderDetail));

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

    @Test
    public void changeOrderState(){
        orderService.changeOrderState(orderSuccess, OrderStateEnum.LISTMADED);

        Assertions.assertEquals(OrderStateEnum.LISTMADED, orderSuccess.getState());
    }
}
