package org.example.Yandex.CodeRun.Task8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                components.add(component);
            }
        }

        writer.write(components.size() + "\n");
        for (var component : components) {
            writer.write(component.size() + "\n");
            for (Integer vertex : component) {
                writer.write(vertex + " ");
            }
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void dfs(int vertex, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (Integer neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}
