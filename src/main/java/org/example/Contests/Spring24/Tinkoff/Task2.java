package org.example.Contests.Spring24.Tinkoff;

// rotate matrix

import java.util.Scanner;

public class Task2 {
//    public static long[][] getRotated(long[][] matrix) {
//        long[][] rotated = new long[matrix[0].length][matrix.length];
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                rotated[col][matrix.length - 1 - row] = matrix[row][col];
//            }
//        }
//        return rotated;
//    }
//
//    public static void printMatrix(long[][] matrix) {
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                System.out.print(matrix[row][col]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }

    public static void printRotated(long[][] matrix) {
        int cols = matrix[0].length;
        int lastRow = matrix.length - 1;
        for (int col = 0; col < cols; col++) {
            for (int row = lastRow; row >= 0; row--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextLong();
            }
        }
        printRotated(matrix);
    }
}
