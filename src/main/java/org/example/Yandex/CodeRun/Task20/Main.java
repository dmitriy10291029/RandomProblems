package org.example.Yandex.CodeRun.Task20;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        System.out.println(largestRectangleArea(array));
    }

    private static long largestRectangleArea(long[] heights) {
        int n = heights.length;

        int[] stack = new int[n];
        int head = -1;

        long[] nextArr = new long[n];
        Arrays.fill(nextArr, n);
        for (int i = 0; i < n; i++) {
            while (head >= 0 && heights[i] < heights[stack[head]]) {
                nextArr[stack[head]] = i;
                head--;
            }
            stack[++head] = i;
        }

        head = -1;
        long[] prevArr = new long[n];
        Arrays.fill(prevArr, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (head >= 0 && heights[i] < heights[stack[head]]) {
                prevArr[stack[head]] = i;
                head--;
            }
            stack[++head] = i;
        }

        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(heights[i] * (nextArr[i] - prevArr[i] - 1), max);
        }

        return max;
    }

}