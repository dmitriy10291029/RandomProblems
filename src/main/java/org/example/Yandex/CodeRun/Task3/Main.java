package org.example.Yandex.CodeRun.Task3;

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
                map[i][j] += Math.max(map[i][j - 1], map[i - 1][j]);
            }
        }

        writer.write(String.valueOf(map[n - 1][m - 1]));
        writer.newLine();

        ArrayDeque<String> dirStack = new ArrayDeque<>();

        int i = n - 1;
        int j = m - 1;

        while (i != 0 && j != 0) {
            if (map[i - 1][j] > map[i][j - 1]) {
                dirStack.push("D ");
                i--;
            } else {
                dirStack.push("R ");
                j--;
            }
        }

        if (i == 0) {
            while (j != 0) {
                j--;
                writer.write("R ");
            }
        } else {
            while (i != 0) {
                i--;
                writer.write("D ");
            }
        }

        while (!dirStack.isEmpty()) {
            writer.write(dirStack.poll());
        }

        reader.close();
        writer.close();
    }
}
