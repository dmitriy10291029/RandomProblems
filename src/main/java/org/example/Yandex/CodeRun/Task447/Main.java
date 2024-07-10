package org.example.Yandex.CodeRun.Task447;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] div1 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        reader.readLine();
        int[] div2 = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        BigInteger num1 = BigInteger.ONE;
        for (int i : div1) {
            num1 = num1.multiply(BigInteger.valueOf(i));
        }
        BigInteger num2 = BigInteger.ONE;
        for (int i : div2) {
            num2 = num2.multiply(BigInteger.valueOf(i));
        }

        var gcd = num1.gcd(num2);
        if (gcd.compareTo(BigInteger.valueOf(1_000_000_000L)) >= 0) {
            gcd = gcd.mod(BigInteger.valueOf(10_000_000_000L));
            writer.write(gcd.toString().substring(1));

        } else {
            writer.write(gcd.toString());
        }

        reader.close();
        writer.close();
    }

}
