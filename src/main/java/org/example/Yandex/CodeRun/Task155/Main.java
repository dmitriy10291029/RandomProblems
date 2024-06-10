package org.example.Yandex.CodeRun.Task155;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");

        for (int i = 0; i < parts.length; i++) {
            int value = Integer.parseInt(parts[i]);
            map.merge(value, 1, (a, b) -> (a + b));
        }

        long ans = map.values().stream().filter(a -> (a == 1)).count();
        writer.write(String.valueOf(ans));
        reader.close();
        writer.close();
    }

}
