package org.example.Yandex.BackendSchool.Contest2;

import java.util.*;

public class Task3v3 {
    public static class Offer implements Comparable<Offer> {
        int u, v, t, cost;

        Offer(int u, int v, int t, int cost) {
            this.u = u;
            this.v = v;
            this.t = t;
            this.cost = cost;
        }

        @Override
        public int compareTo(Offer other) {
            return this.cost - other.cost;
        }
    }

    public static class Request {
        int u, v, t;

        Request(int u, int v, int t) {
            this.u = u;
            this.v = v;
            this.t = t;
        }
    }

    public static boolean checkGraph(int n, int[][] currGraph, List<Request> requirements) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (currGraph[i][j] != 0) {
                    dist[i][j] = currGraph[i][j];
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (Request request : requirements) {
            if (dist[request.u][request.v] > request.t) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            graph[u][v] = t;
            graph[v][u] = t;
        }

        int k = scanner.nextInt();
        List<Offer> offers = new ArrayList<>();
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            offers.add(new Offer(u, v, t, c));
            mn = Math.min(mn, c);
            mx = Math.max(mx, c);
        }

        int p = scanner.nextInt();
        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = scanner.nextInt();
            requests.add(new Request(a, b, t));
        }

        int left = mn, right = mx, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[][] temp = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                temp[i] = Arrays.copyOf(graph[i], n + 1);
            }

            for (Offer offer : offers) {
                if (offer.cost <= mid) {
                    temp[offer.u][offer.v] = offer.t;
                    temp[offer.v][offer.u] = offer.t;
                }
            }

            if (checkGraph(n + 1, temp, requests)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            ans = mid;
        }

        if (right < mn - 1) {
            System.out.println(0);
        } else if (ans == -1) {
            System.out.println(-1);
        } else {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < offers.size(); i++) {
                if (offers.get(i).cost <= ans) {
                    res.add(i + 1);
                }
            }

            System.out.println(res.size());
            for (int road : res) {
                System.out.print(road + " ");
            }
            System.out.println();
        }
    }
}

