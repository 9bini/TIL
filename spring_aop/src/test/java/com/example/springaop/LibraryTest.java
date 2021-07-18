package com.example.springaop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryTest {

    @Autowired
    private Library library;


    @Test
    void test(){
        // Given
        library.setName("부산도서관");
        // When
        String name = library.getName();

        // Then
        assertThat(name).isNotEmpty();
        assertThat(name).isEqualTo("부산도서관");
    }

    @Test
    void testVisitedBy(){
        // Given
        library.setName("부산도서관");

        // When
        User user = new User();
        user.setName("스프링");
        // Then
        library.visitedBy(user);
    }
}