package org.example.Yandex.CodeRun.Task182;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static long getDifficult(long a, long b) {
        long answer = 1;

        if (a == b) {
            return 1L;
        }
        if (a == 1 || b == 1) {
            return 2L;
        }
        if (b % a != 0) {
            return 0L;
        }
        long k = b / a;
        long nPrimeDivisors = 0;

        long divisor = 2;
        long maxDivisor = Math.round(Math.sqrt(k)) + 1;

        while (k > 1 && divisor <= maxDivisor) {
            if (k % divisor == 0) { // находим делитель
                nPrimeDivisors++;
                do { // удаляем его из числа полностью
                    k /= divisor;
                } while (k > 1 && k % divisor == 0);
            }
            divisor++;
        }

        if (nPrimeDivisors == 0) {
            return 2;

        } else {
            do {
                answer *= 2;
                nPrimeDivisors--;
            } while (nPrimeDivisors != 0);

            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");
        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[1]);
        writer.write(String.valueOf(getDifficult(a, b)));
        reader.close();
        writer.close();
    }

}

