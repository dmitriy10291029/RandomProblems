package org.example.Contests.Spring24.Tinkoff;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    void Test1() {
        InputStream inputStream = new StringBufferInputStream("""
                5
                W.W
                C.C
                WW.
                CC.
                CWW
                """);
        assertEquals(3, Task5.getMax(Task5.getField(inputStream)));
    }

    @Test
    void Test2() {
        InputStream inputStream = new StringBufferInputStream("""
                4
                W.W
                CWC
                W.W
                CWW
                """);
        assertEquals(2, Task5.getMax(Task5.getField(inputStream)));
    }

    @Test
    void Test3() {
        InputStream inputStream = new StringBufferInputStream("""
                4
                W.W
                ..C
                WW.
                C..
                """);
        assertEquals(1, Task5.getMax(Task5.getField(inputStream)));
    }

    @Test
    void Test4() {
        InputStream inputStream = new StringBufferInputStream("""
                4
                WWW
                ..C
                WW.
                C..
                """);
        assertEquals(0, Task5.getMax(Task5.getField(inputStream)));
    }

    @Test
    void Test5() {
        InputStream inputStream = new StringBufferInputStream("""
                1
                C..
                """);
        assertEquals(1, Task5.getMax(Task5.getField(inputStream)));
    }
}