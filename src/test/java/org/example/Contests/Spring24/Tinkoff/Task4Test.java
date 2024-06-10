package org.example.Contests.Spring24.Tinkoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    public static void print(long[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    void Test1() {
        int n = 1;
        long[][] m = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = i * n + j + 1;
            }
        }
        print(m);

        var ops = Task4.leftRotate(n);
        for (var op : ops) {
            long temp = m[op.A][op.B];
            m[op.A][op.B] = m[op.C][op.D];
            m[op.C][op.D] = temp;
        }
        print(m);
    }

    @Test
    void Test2() {
        int n = 2;
        long[][] m = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = i * n + j + 1;
            }
        }
        print(m);

        var ops = Task4.rightRotate(n);
        for (var op : ops) {
            long temp = m[op.A][op.B];
            m[op.A][op.B] = m[op.C][op.D];
            m[op.C][op.D] = temp;
        }
        print(m);
    }

}