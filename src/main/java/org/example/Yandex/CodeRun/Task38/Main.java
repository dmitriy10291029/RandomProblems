package org.example.Yandex.CodeRun.Task38;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int dfs(int[][] map, int x, int y) {
        if (map[x][y] == 1) {
            return 0;
        } else {
            map[x][y] = 1;
            return 1
                    + dfs(map, x + 1, y)
                    + dfs(map, x - 1, y)
                    + dfs(map, x, y + 1)
                    + dfs(map, x, y - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = reader.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (line[j] == '*') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        String[] startCoords = reader.readLine().split(" ");
        int x0 = Integer.parseInt(startCoords[0]) - 1;
        int y0 = Integer.parseInt(startCoords[1]) - 1;

        int area = dfs(map, x0, y0);
        writer.write(String.valueOf(area));

        reader.close();
        writer.close();
    }

}
