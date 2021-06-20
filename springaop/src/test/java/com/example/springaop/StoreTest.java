package com.example.springaop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreTest {

    @Test
    void test(){

        Store store = new Store();
        assertThat(store.getOperationTime()).isEqualTo("AM 08:00 ~ PM 08:00");
    }



}