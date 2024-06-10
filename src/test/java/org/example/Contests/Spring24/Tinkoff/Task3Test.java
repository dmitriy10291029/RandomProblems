package org.example.Contests.Spring24.Tinkoff;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    void Test1() {
        InputStream inputStream = new StringBufferInputStream("""
                6
                root/a
                root/a/b
                root/c/x
                root/a/b/c
                root
                root/c
                """);

        Task3.printSortedAndFormatted(inputStream);
    }

    @Test
    void Test2() {
        InputStream inputStream = new StringBufferInputStream("""
                4
                a/b/c/d
                a/b
                a/b/c
                a
                """);
        Task3.printSortedAndFormatted(inputStream);
    }

    @Test
    void Test3() {
        InputStream inputStream = new StringBufferInputStream("""
                1
                dimasik
                """);
        Task3.printSortedAndFormatted(inputStream);
    }
    @Test
    void Test4() {
        InputStream inputStream = new StringBufferInputStream("""
                7
                d
                d/a
                d/a/e
                d/f/e
                d/h/t
                d/a/e/h
                d/a/e/h/g
                """);
        Task3.printSortedAndFormatted(inputStream);
    }
}