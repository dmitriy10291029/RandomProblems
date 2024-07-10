package org.example.Yandex.CodeRun.Task442;


import java.io.*;
import java.util.Arrays;

public class Main {
    public static class SegmentTree {
        private final int[] tree;
        private final int[] lazy;
        private final int n;
        private final static int MOD = 1_000_000_007;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            lazy = new int[4 * n];
            buildTree(arr, 0, 0, n - 1);
        }

        private void buildTree(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                int leftChild = 2 * node + 1;
                int rightChild = 2 * node + 2;
                buildTree(arr, leftChild, start, mid);
                buildTree(arr, rightChild, mid + 1, end);
                tree[node] = (int)((long)tree[leftChild] * tree[rightChild] % MOD);
            }
        }

        public void updateRange(int l, int r, int val) {
            updateRange(0, 0, n - 1, l, r, val);
        }

        private void updateRange(int node, int start, int end, int l, int r, int val) {
            if (lazy[node] != 0) {
                propagate(node, start, end);
            }

            if (start > end || start > r || end < l) {
                return;
            }

            if (start >= l && end <= r) {
                lazy[node] += val;
                propagate(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            updateRange(leftChild, start, mid, l, r, val);
            updateRange(rightChild, mid + 1, end, l, r, val);
            tree[node] = (int)((long)tree[leftChild] * tree[rightChild] % MOD);
        }

        private void propagate(int node, int start, int end) {
            tree[node] = (int)((long)tree[node] * pow(1, lazy[node]) % MOD);
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }

        public int queryRange(int l, int r) {
            return queryRange(0, 0, n - 1, l, r);
        }

        private int queryRange(int node, int start, int end, int l, int r) {
            if (start > end || start > r || end < l) {
                return 1; // Для произведения нейтральный элемент 1
            }

            if (lazy[node] != 0) {
                propagate(node, start, end);
            }

            if (start >= l && end <= r) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            int leftQuery = queryRange(leftChild, start, mid, l, r);
            int rightQuery = queryRange(rightChild, mid + 1, end, l, r);
            return (int)((long)leftQuery * rightQuery % MOD);
        }

        private int pow(int base, int exp) {
            long result = 1;
            long b = base;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * b) % MOD;
                }
                b = (b * b) % MOD;
                exp >>= 1;
            }
            return (int)result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");
        int[] array = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        SegmentTree tree = new SegmentTree(array);
        int k = Integer.parseInt(reader.readLine());
        for (int i = 0; i < k; i++) {
            int[] op = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (op[0] == 0) {
                tree.updateRange(op[1] - 1, op[2], 1);

            } else if (op[0] == 1) {
                writer.write(tree.queryRange(op[1] - 1, op[2]) + "\n");

            }
        }

        reader.close();
        writer.close();
    }
}
