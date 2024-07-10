package org.example.Yandex.CodeRun.Task437;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[n][m];
        int xOfMax = -1;
        int yOfMax = -1;
        int maxSize = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {

                    if (i == n - 1 || j == m - 1) {
                        dp[i][j] = 1;

                    } else {
                        dp[i][j] = 1 + Stream.of(dp[i][j + 1], dp[i + 1][j], dp[i + 1][j + 1])
                                .min(Integer::compareTo).get();
                    }

                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        xOfMax = i;
                        yOfMax = j;
                    }
                }
            }
        }

        writer.write(maxSize + "\n");
        writer.write((xOfMax + 1) + " " + (yOfMax + 1));

        reader.close();
        writer.close();
    }

}

