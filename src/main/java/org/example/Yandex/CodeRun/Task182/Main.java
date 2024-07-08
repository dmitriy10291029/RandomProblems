package org.example.Yandex.CodeRun.Task182;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);

        if (y % x != 0) {
            writer.write("0\n");
            reader.close();
            writer.close();
            return;
        }

        long z = y / x;
        int count = 0;

        for (long a = 1; a * a <= z; a++) {
            if (z % a == 0) {
                long b = z / a;
                if (gcd(a, b) == 1) {
                    count++;
                    if (a != b) {
                        count++;
                    }
                }
            }
        }

        writer.write(count + "\n");
        reader.close();
        writer.close();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
