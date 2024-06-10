package org.example.Yandex.BackendSchool.Contest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static class Offer implements Comparable<Offer> {
        public int u, v, time, price;

        public Offer(int u, int v, int time, int price) {
            this.u = u;
            this.v = v;
            this.time = time;
            this.price = price;
        }

        @Override
        public int compareTo(Offer other) {
            return this.price - other.price;
        }
    }

    public static class Request {
        public int u, v, t;

        public Request(int u, int v, int t) {
            this.u = u;
            this.v = v;
            this.t = t;
        }
    }

    public static int[][] getShortestDist(int[][] graph) {
        // floyd-warshall
        final int n = graph.length;
        final int INF = Integer.MAX_VALUE;

        int[][] dist = new int[n][n];
        for (var row : dist)
            Arrays.fill(row, INF);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j)
                    dist[i][j] = 0;
                else if (graph[i][j] != 0)
                    dist[i][j] = graph[i][j];

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    public static boolean checkGraph(int[][] graph, Request[] requests) {
        int[][] dist = getShortestDist(graph);
        for (Request r : requests)
            if (dist[r.u][r.v] > r.t)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // init graph
        int n = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            graph[u][v] = graph[v][u] = t;
        }

        // init offers
        int k = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Offer[] offers = new Offer[k];
        for (int i = 0; i < k; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            offers[i] = new Offer(u, v, t, c);
            min = Math.min(min, c);
            max = Math.max(max, c);
        }

        // init requests
        int p = scanner.nextInt();
        Request[] requests = new Request[p];
        for (int i = 0; i < p; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = scanner.nextInt();
            requests[i] = new Request(a, b, t);
        }

        // binarySearch;

        int left = min;
        int right = max;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[][] temp = graph.clone();
            for (Offer offer : offers) {
                if (offer.price <= mid) {
                    temp[offer.u][offer.v] = offer.time;
                    temp[offer.v][offer.u] = offer.time;
                }
            }
            if (checkGraph(temp, requests)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            ans = mid;
        }

        // print answer

        if (right < min - 1) {
            System.out.println(0);
            return;
        }
        if (ans == -1) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < offers.length; i++) {
            if (offers[i].price <= ans) {
                res.add(i + 1);
            }
        }

        System.out.println(res.size());
        for (var road : res) {
            System.out.print(road + " ");
        }
    }
}
