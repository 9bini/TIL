package com.example.springaop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired private Store store;

    @Autowired private Library library;

    @Test
    void test(){
        User user = new User();
        assertThat(user.greetring()).isEqualTo("Hello");
    }

    @Test
    void testVisitToStore(){
        // Given
        User user = new User();
        user.setName("스프링");

        store.setVisitCountByUser(11);
        // When
        user.visitTo(store);

        // Then


    }

    @Test
    void testVisitToLibrary(){
        // Given
        User user = new User();
        user.setName("AOP");
        library.setName("행복도서관");

        // When
        user.visitTo(library);
        // Then

    }
}