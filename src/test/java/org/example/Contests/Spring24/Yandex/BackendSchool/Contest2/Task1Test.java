package org.example.Contests.Spring24.Yandex.BackendSchool.Contest2;

import org.example.Yandex.BackendSchool.Contest2.Task1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void Test1() {
        Task1.Grid grid = new Task1.Grid();
        grid.setFigure(1, 2, Task1.Figure.first);
        grid.setFigure(1000_000_000, 1_000_000_000, Task1.Figure.second);
        assertEquals(Task1.Figure.first, grid.getFigure(1, 2));
        assertEquals(Task1.Figure.second, grid.getFigure(1_000_000_000, 1_000_000_000));
        assertEquals(Task1.Figure.empty, grid.getFigure(12313,-53543));
    }

}