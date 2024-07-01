package org.example.Yandex.CodeRun.Task39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            parts = reader.readLine().split(" ");
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;

            graph[b][a] = 1;
        }
        dfs(graph, visited, 0);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                writer.write(String.valueOf(i + 1));
                writer.write(" ");
            }
        }
        reader.close();
        writer.close();
    }

}
