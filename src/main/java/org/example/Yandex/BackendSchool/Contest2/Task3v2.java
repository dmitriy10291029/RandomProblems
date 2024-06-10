package org.example.Yandex.BackendSchool.Contest2;

import java.util.Arrays;
import java.util.Scanner;

public class Task3v2 {
    final static int INF = Integer.MAX_VALUE;

    public static class Offer {
        public int u, v, time, price;

        public Offer(int u, int v, int time, int price) {
            this.u = u;
            this.v = v;
            this.time = time;
            this.price = price;
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

    public static int[][] toShortestDist(int[][] graph) {
        final int n = graph.length;
        for (int i = 1; i < n; i++)
            for (int u = 1; u < n; u++)
                for (int v = 1; v < n; v++)
                    if (graph[u][i] != INF && graph[i][v] != INF && ((long)graph[u][i]) + graph[i][v] < graph[u][v])
                        graph[u][v] = graph[u][i] + graph[i][v];
        return graph;
    }

    public static boolean checkShortestDist(int[][] dist, Request[] requests) {
        for (Request r : requests)
            if (dist[r.u][r.v] > r.t)
                return false;

        return true;
    }

    public static int binarySearch(int[][] graph, Offer[] offers, Request[] requests) {
        var minMax = Arrays.stream(offers).mapToInt(o -> o.price).summaryStatistics();
        int left = minMax.getMin(), right = minMax.getMax();
        int optimalPrice = -1;
        int n = graph.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                temp[i] = Arrays.copyOf(graph[i], n);
            }

            for (Offer offer : offers) {
                if (offer.price <= mid) {
                    temp[offer.u][offer.v] = offer.time;
                    temp[offer.v][offer.u] = offer.time;
                } else {
                    break;
                }
            }
            toShortestDist(temp);
            if (checkShortestDist(temp, requests)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            optimalPrice = mid;
        }

        if (right < minMax.getMin() - 1) {
            optimalPrice = 0;
        }

        return optimalPrice;
    }

    public static void printResult(Offer[] offers, int ans) {
        if (ans == -1 || ans == 0) {
            System.out.println(ans);
            return;
        }

        int[] res = new int[offers.length];
        int resLen = 0;
        for (int i = 0; i < offers.length; i++) {
            if (offers[i].price <= ans) {
                res[resLen++] = i + 1;
            }
        }

        System.out.println(resLen);
        for (int i = 0; i < resLen; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // init graph
        int n = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (var row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            graph[u][v] = graph[v][u] = t;
        }

        // init offers
        int k = scanner.nextInt();
        Offer[] offers = new Offer[k];
        for (int i = 0; i < k; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            offers[i] = new Offer(u, v, t, c);
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

        int[][] graphCopy = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            graphCopy[i] = Arrays.copyOf(graph[i], n + 1);
        }
        if (checkShortestDist(toShortestDist(graphCopy), requests)) {
            System.out.println(0);
        } else {
            int ans = binarySearch(graph, offers, requests);
            printResult(offers, ans);
        }
    }
}
