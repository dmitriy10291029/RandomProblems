package org.example.Yandex.CodeRun.Task11;
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] graph;
    private static boolean[] visited;
    private static int[] parent;
    private static List<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);

        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            parts = reader.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(parts[j - 1]);
            }
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        cycle = new ArrayList<>();

        boolean hasCycle = false;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            writer.write("YES\n");
            writer.write(cycle.size() + "\n");
            for (int v : cycle) {
                writer.write(v + " ");
            }
            writer.write("\n");
        } else {
            writer.write("NO\n");
        }

        reader.close();
        writer.close();
    }

    private static boolean dfs(int v, int parentV) {
        visited[v] = true;
        for (int u = 1; u < graph.length; u++) {
            if (graph[v][u] == 1) {
                if (!visited[u]) {
                    parent[u] = v;
                    if (dfs(u, v)) {
                        return true;
                    }
                } else if (u != parentV) {
                    cycle.add(u);
                    for (int cur = v; cur != u; cur = parent[cur]) {
                        cycle.add(cur);
                    }

                    return true;
                }
            }
        }
        return false;
    }
}
