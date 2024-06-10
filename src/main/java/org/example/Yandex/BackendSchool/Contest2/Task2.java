package org.example.Yandex.BackendSchool.Contest2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    public static int[] getPurchasedFish(int n, int k, int[] extPrices) {
        int[] purchasedFish = new int[n];

        // min in sliding window problem
        int[] minimums = new int[n];
        int minimumsSize = 0;
        int start = 0;
        int end = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (end < extPrices.length) {
            while (!dq.isEmpty() && extPrices[dq.getFirst()] > extPrices[end]) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && extPrices[dq.getLast()] > extPrices[end]) {
                dq.removeLast();
            }

            dq.addLast(end);
            if (end - start + 1 == k) {
                minimums[minimumsSize++] = dq.getFirst() - k + 1;
                if (extPrices[dq.getFirst()] == extPrices[start++]) {
                    dq.removeFirst();
                }
            }
            ++end;
        }

        for (int i : minimums) {
            purchasedFish[i]++;
        }

        return purchasedFish;
    }

    public static void solve(InputStream input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        int k = Math.min(n, scanner.nextInt());

        int[] extPrices = new int[n + k - 1];
        for (int i = 0; i < k - 1; ++i) {
            extPrices[i] = Integer.MAX_VALUE;
        }
        for (int i = k - 1; i < extPrices.length; ++i) {
            extPrices[i] = scanner.nextInt();
        }

        int[] purchasedFish = getPurchasedFish(n, k, extPrices);

        long moneySum = 0;
        for (int i = 0; i < n; ++i) {
            moneySum += ((long) purchasedFish[i]) * extPrices[i + k - 1];
        }
        System.out.println(moneySum);

        for (int amountOfFish : purchasedFish) {
            System.out.print(amountOfFish);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        solve(System.in);
    }
}
