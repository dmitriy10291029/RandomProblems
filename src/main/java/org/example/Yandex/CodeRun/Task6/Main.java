package org.example.Yandex.CodeRun.Task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int l1 = Integer.parseInt(reader.readLine());
        int[] s1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l2 = Integer.parseInt(reader.readLine());
        int[] s2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] m = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (s1[i] == s2[j]) {
                    m[i + 1][j + 1] = m[i][j] + 1;
                } else {
                    m[i + 1][j + 1] = Math.max(m[i][j + 1], m[i + 1][j]);
                }
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = l1 - 1, j = l2 - 1;

        while (j >= 0 && i >= 0) {
            if (s1[i] == s2[j]) {
                stack.push(s1[i]);
                i--;
                j--;
            } else if (m[i][j + 1] > m[i + 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        while (!stack.isEmpty()) {
            writer.write(stack.poll() + " ");
        }

        reader.close();
        writer.close();
    }
}
