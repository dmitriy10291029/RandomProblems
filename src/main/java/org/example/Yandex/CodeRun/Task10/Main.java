package org.example.Yandex.CodeRun.Task10;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            parts = reader.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[N + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        if (stack.size() != graph.size()) {
            writer.write("-1");
        } else {
            while (!stack.isEmpty()) {
                writer.write(stack.pop() + " ");
            }
        }

        reader.close();
        writer.close();
    }

    private static void dfs(int v, boolean[] visited, Deque<Integer> stack, List<List<Integer>> graph) {
        visited[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, graph);
            }
        }
        stack.push(v);
    }
}
