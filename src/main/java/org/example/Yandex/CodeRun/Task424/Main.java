package org.example.Yandex.CodeRun.Task424;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(getNextHappy(reader.readLine()));

        reader.close();
        writer.close();
    }

    private static String getNextHappy(String input) {
        int[] nums = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        int n = nums.length;
        int maxSumOfHalf = 9 * n / 2;
        int s1 = Arrays.stream(nums).limit(n / 2).sum();
        int s2 = Arrays.stream(nums).skip(n / 2).sum();

        boolean isMax = false;

        if (s1 == maxSumOfHalf) { // крайние случаи
            if (s1 == s2) {
                nums = new int[n];

            } else {
                isMax = true;
            }

        }
        if (!isMax) {
            // уменьшаем вторую половину, чтобы само число стало больше
            if (s1 <= s2) {
                // 988999 -> 989899
                // 89999 -> 990099
                // 8898 -> 8989
                // 8889 -> 8897
                // 111990 -> 112004
                // 11119782 -> 11120005
                // 991999 -> 992299
                // 00996655 -> 00996660
                int i = n - 1;

                do {
                    // текущее выставляем в 0
                    s2 -= nums[i];
                    nums[i] = 0;

                    // ищем разряд для переноса
                    i--;
                    while (nums[i] == 9) {
                        if (i >= n / 2) s2 -= nums[i]; else s1 -= nums[i];
                        nums[i--] = 0;
                    }
                    // переносим
                    nums[i]++;
                    if (i >= n / 2) s2++; else s1++;
                } while (s1 < s2);
            }
            // увеличиваем вторую половину до первой
            int sumDiff = s1 - s2;
            int i = n - 1;

            while (sumDiff > 0) {
                int subtracted = Math.min(sumDiff, 9 - nums[i]);
                sumDiff -= subtracted;
                nums[i--] += subtracted;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isMax) {
            sb.append("9".repeat(n));
        } else {
            for (int num : nums) {
                sb.append(num);
            }
        }

        return sb.toString();
    }

    private static String getNextHappyNaive(String input) {
        int n = input.length();
        long num = Long.parseLong(input);
        long maxValue = Long.parseLong("9".repeat(n));

        if (num == maxValue) {
            num = 0;
        }

        long s1, s2;
        do {
            num++;
            long temp = num;
            s2 = 0;
            for (int i = 0; i < n / 2; i++) {
                s2 += temp % 10;
                temp /= 10;
            }

            s1 = 0;
            while (temp > 0) {
                s1 += temp % 10;
                temp /= 10;
            }

        } while (s1 != s2);

        StringBuilder sb = new StringBuilder();
        sb.append(num);
        if (sb.length() != n) {
            sb.insert(0, "0".repeat(n - sb.length()));
        }

        return sb.toString();
    }
}
