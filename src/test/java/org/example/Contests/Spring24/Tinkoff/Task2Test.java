package org.example.Contests.Spring24.Tinkoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void Test1() {
        Task2.printRotated(new long[][]{{1, 1},{2, 3}});
    }

    @Test
    void Test2() {
        Task2.printRotated(new long[][]{{1, 2, 3},{4, 5, 6}});
    }

    @Test
    void Test3() {
        Task2.printRotated(new long[][]{{69}});
    }
}