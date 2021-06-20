package com.example.springaop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Test
    void test(){
        User user = new User();

        assertThat(user.greetring()).isEqualTo("Hello");
    }

    @Test
    void testVisitTo(){
        User user = new User();
        user.setName("사장");
        user.visitTo(new Store());
    }
}