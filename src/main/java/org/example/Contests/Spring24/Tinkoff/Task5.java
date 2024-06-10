package org.example.Contests.Spring24.Tinkoff;

import java.io.InputStream;
import java.util.Scanner;

public class Task5 {
    public static int getMax(int[][] field) {
        int[][] backpack = new int[field.length][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < 3; j++) {
                backpack[i][j] = -1;
            }
        }
        System.arraycopy(field[0], 0, backpack[0], 0, 3);

        for (int i = 1; i < field.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k < 3
                            && backpack[i - 1][j + k] != -1
                            && field[i][j] != -1)
                    {
                        backpack[i][j] = Math.max(
                                backpack[i][j],
                                backpack[i - 1][j + k] + field[i][j]
                        );
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < field.length; i++) {
            for(int j = 0; j < 3; j++) {
                max = Math.max(max, backpack[i][j]);
            }
        }

        return max;
    }

    public static int[][] getField(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int n = scanner.nextInt();
        int[][] field = new int[n][3];
        for (int i = 0; i < field.length; i++) {
            char[] row = scanner.next().toCharArray();
            for (int j = 0; j < 3; j++) {
                switch (row[j]) {
                    case 'W' -> field[i][j] = -1;
                    case '.' -> field[i][j] = 0;
                    case 'C' -> field[i][j] = 1;
                }
            }
        }
        return field;
    }

    public static void main(String[] args) {
        System.out.println(getMax(getField(System.in)));
    }
}
