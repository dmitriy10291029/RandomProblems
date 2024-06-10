package org.example.Contests.Spring24.Tinkoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void Test1() {
        assertEquals(4, Task1.getMaxFives(new int[]{5,5,4,5,4,5,4,5,4}));
    }

    @Test
    void Test2() {
        assertEquals(2, Task1.getMaxFives(new int[]{3,4,4,4,4,5,4,5}));
    }

    @Test
    void Test3() {
        assertEquals(-1, Task1.getMaxFives(new int[]{5,5,5,5,5,3,5,5,5,5}));
    }
}