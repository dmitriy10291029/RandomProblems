package org.example.Contests.Spring24.Yandex.BackendSchool.Contest1;

import org.example.Yandex.BackendSchool.Contest1.Task1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void Test1() {
        assertTrue(Task1.checkName("d1Ddadad"));
        assertTrue(Task1.checkName("EmObOy2005"));
        assertTrue(Task1.checkName("200000dT"));
        assertFalse(Task1.checkName("altushka"));
        assertFalse(Task1.checkName("sdfsfd"));
        assertFalse(Task1.checkName("s1D"));
    }

}