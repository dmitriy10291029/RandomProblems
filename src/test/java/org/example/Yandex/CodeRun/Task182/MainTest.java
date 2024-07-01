package org.example.Yandex.CodeRun.Task182;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void Test1() {
        assertEquals(2, Main.getDifficult(5, 10));
    }

    @Test
    void Test2() {
        assertEquals(0, Main.getDifficult(10, 11));
    }

    @Test
    void Test3() {
        assertEquals(4, Main.getDifficult(527, 9486));
    }

    @Test
    void Test4() {
        assertEquals(2, Main.getDifficult(2L, 133361464567L * 2L));
    }

    @Test
    void Test5() {
        assertEquals(2, Main.getDifficult(101419L, 101419L * 101419L));
    }
}