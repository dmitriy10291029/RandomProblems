package org.example.Yandex.CodeRun.Task1;

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
        String[] parts = reader.readLine().split(" ");
        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            ints[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(ints);
        writer.write(String.valueOf(ints[1]));
        reader.close();
        writer.close();
    }

}
