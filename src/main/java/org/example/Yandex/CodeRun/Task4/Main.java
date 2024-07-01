package org.example.Yandex.CodeRun.Task4;

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static public class IntVector {
        public int x;
        public int y;

        public IntVector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;

        String[] parts = reader.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = new int[m];
        }
        map[0][0] = 1;
        ArrayDeque<IntVector> turns = new ArrayDeque<>();
        turns.push(new IntVector(0, 0));

        int[][] availableTurns = new int[][] {{1, 2}, {2, 1}};

        while (!turns.isEmpty()) {
            IntVector turn = turns.pollLast();
            //System.out.println(turn.x + " " + turn.y + " " + map[turn.x][turn.y]);
            for (var availableTurn : availableTurns) {
                IntVector newTurn = new IntVector(turn.x + availableTurn[0], turn.y + availableTurn[1]);
                if (newTurn.x < n && newTurn.y < m) {
                    if (map[newTurn.x][newTurn.y] == 0) {
                        turns.push(newTurn);
                    }
                    map[newTurn.x][newTurn.y] += map[turn.x][turn.y];
                }
            }
        }

        writer.write(String.valueOf(map[n - 1][m - 1]));
        reader.close();
        writer.close();
    }
}
