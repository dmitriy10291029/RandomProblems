package org.example.Contests.Spring24.Yandex.BackendSchool.Contest2;

import org.example.Yandex.BackendSchool.Contest2.Task2;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringBufferInputStream;

class Task2Test {
    @Test
    void Test1() {
        InputStream inputStream = new StringBufferInputStream("""
                2 1
                1 2
                """);
        Task2.solve(inputStream);
    }

    @Test
    void Test2() {
        InputStream inputStream = new StringBufferInputStream("""
                2 1
                1 2
                """);
        Task2.solve(inputStream);
    }
}