package org.example.Yandex.CodeRun.Task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;

        String[] parts = reader.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i < n; i++) {
            map[i][0] += map[i - 1][0];
        }

        for (int j = 1; j < m; j++) {
            map[0][j] += map[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] += Math.min(map[i][j - 1], map[i - 1][j]);
            }
        }

        writer.write(String.valueOf(map[n - 1][m - 1]));

        reader.close();
        writer.close();
    }

}
