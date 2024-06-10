package org.example.Yandex.CodeRun.Task17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            double[] line = new double[Integer.parseInt(parts[0])];
            for (int j = 1; j < parts.length; j++) {
                line[j - 1] = Double.parseDouble(parts[j]);
            }

            int ans = 1;
            double[] sortedLine = Arrays.copyOf(line, line.length);
            Arrays.sort(sortedLine);

            ArrayDeque<Double> stack = new ArrayDeque<>();

            int k = 0; // sorted line iterator
            for (int j = 0; j < line.length;) { // line iterator
                if (stack.size() > 0 && sortedLine[k] == stack.peek()) {
                    stack.pop();
                    k++;
                } else if (sortedLine[k] == line[j]) {
                    k++;
                    j++;
                } else {
                    stack.push(line[j]);
                    j++;
                }
            }
            while (stack.size() != 0) {
                if (sortedLine[k] == stack.pop()) {
                    k++;
                } else {
                    ans = 0;
                    break;
                }
            }
            // 1 2 3 5 6 4 7 8 9
            // 1 2 3 4 5 6 7 8 9

            writer.write(String.valueOf(ans));
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

}
