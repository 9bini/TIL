package com.fastcampus.inventorytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    private int fibonacci(int num) {
        if (num < 0) return 0;
        if (num <= 1) return num;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    @Test
    void testFibonacci_0() {
        int input = 0;
        int output = fibonacci(input);
        Assertions.assertEquals(0, output);
    }

    @Test
    void testFibonacci_1() {
        int input = 1;
        int output = fibonacci(input);
        Assertions.assertEquals(1, output);
    }

    @Test
    void testFibonacci_2() {
        int input = 2;
        int output = fibonacci(input);
        Assertions.assertEquals(1, output);
    }

    @Test
    void testFibonacci_3() {
        int input = 3;
        int output = fibonacci(input);
        Assertions.assertEquals(2, output);
    }

    @Test
    void testFibonacci_n1() {
        int input = -1;
        int output = fibonacci(input);
        Assertions.assertEquals(0, output);
    }
    @Test
    void testFibonacci_10() {
        int input = 10;
        int output = fibonacci(input);
        Assertions.assertEquals(55, output);
    }
}