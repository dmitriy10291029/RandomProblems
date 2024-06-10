package org.example.Yandex.CodeRun.Task182;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().split(" ");

        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[1]);
        long answer = 1;

        if (a == b) {
            answer = 1;
        } else if (a == 1 || b == 1) {
            answer = 2;
        } else if (b % a != 0) {
            answer = 0;
        } else {
            long k = b / a;
            long nPrimeDivisors = 0;

            long divisor = 2;
            while (k > 1) {
                if (k % divisor == 0) { // находим делитель
                    nPrimeDivisors++;
                    do { // удаляем его из числа полностью
                        k /= divisor;
                    } while (k > 1 && k % divisor == 0);
                }
                divisor++;
            }

            while (nPrimeDivisors != 0) {
                answer *= 2;
                nPrimeDivisors--;
            }
        }

        writer.write(String.valueOf(answer));

        reader.close();
        writer.close();
    }

}

