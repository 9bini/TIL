package com.fastcampus.pickingtdd.service;

import com.fastcampus.pickingtdd.entity.OrderDetail;
import com.fastcampus.pickingtdd.entity.Sku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class OrderDetailServiceTest{

    @Autowired
    OrderDetailService orderDetailService;

    OrderDetail orderDetailSuccess;
    OrderDetail orderDetailFail;

    @BeforeEach
    public void setup(){
        orderDetailSuccess = new OrderDetail();
        orderDetailSuccess.setId(1l);
        orderDetailSuccess.setOrderId(1l);
        orderDetailSuccess.setSku(new Sku());
        orderDetailSuccess.setAmount(10);

        orderDetailFail = new OrderDetail();
    }

    @Test
    void testMake_success(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(1l);
        orderDetail.setOrderId(1l);
        orderDetail.setSku(new Sku());
        orderDetail.setAmount(10);


        // Setting
        OrderDetail make = null;
        try {
            make = orderDetailService.makeOrderDetail(orderDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(1L, make.getId());
        Assertions.assertEquals(1L, make.getOrderId());
        Assertions.assertEquals(10, make.getAmount());

    }

    @Test
    void testValidation_success() {
        OrderDetail makeOrderDetail = null;
        try {
             makeOrderDetail = orderDetailService.makeOrderDetail(orderDetailSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }
        Assertions.assertEquals(1L, makeOrderDetail.getId());
        Assertions.assertEquals(1L, makeOrderDetail.getOrderId());
        Assertions.assertEquals(10, makeOrderDetail.getAmount());
    }

    @Test
    public void testValidation_fail(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> orderDetailService.makeOrderDetail(orderDetailFail));
        assertEquals("orderDetail validation fail", exception.getMessage());
    }
}
