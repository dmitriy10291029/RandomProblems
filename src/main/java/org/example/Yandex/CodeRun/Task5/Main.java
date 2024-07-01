package org.example.Yandex.CodeRun.Task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] prices = new int[n];
        int sum = 0;
        boolean[] usedCoupon = new boolean[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
            sum += prices[i];
        }

        int unusedCoupons = 0;
        int usedCoupons = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] > 100) {

                int max = -1;
                int idxOfMax = -1;

                for (int j = i + 1; j < n; j++) {
                    if (!usedCoupon[j] && prices[j] > max) {
                        max = prices[j];
                        idxOfMax = j;
                    }
                }

                if (idxOfMax == -1) {
                    unusedCoupons++;

                } else {
                    usedCoupons++;
                    sum -= prices[idxOfMax];
                    usedCoupon[idxOfMax] = true;
                }
            }
        }
        writer.write(String.valueOf(sum));
        writer.newLine();
        writer.write(unusedCoupons + " " + usedCoupons);
        writer.newLine();

        for (int i = 0; i < n; i++) {
            if (usedCoupon[i]) {
                writer.write((i + 1) + " ");
            }
        }

        reader.close();
        writer.close();
    }
}

