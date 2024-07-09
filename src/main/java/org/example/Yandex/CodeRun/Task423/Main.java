package org.example.Yandex.CodeRun.Task423;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        parts = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int coord = Integer.parseInt(parts[i - 1]);
            var stations = map.get(coord);
            if (stations != null) {
                stations.add(i);
            } else {
                stations = new ArrayList<>();
                stations.add(i);
                map.put(coord, stations);
            }
        }

        int[] x = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < k; i++) {
            int ans;
            if (map.containsKey(x[i])) {
                ans = Collections.min(map.get(x[i]));

            } else {
                Integer left = map.floorKey(x[i]);
                Integer right = map.ceilingKey(x[i]);

                if (left == null) { // only right - min
                    ans = Collections.min(map.get(right));

                } else if (right == null) { // only left - max
                    ans = Collections.max(map.get(left));

                } else if (x[i] - left == right - x[i]) { // left and right - max left
                    ans = Collections.max(map.get(left));

                } else if (x[i] - left < right - x[i]) { // left is nearest - max
                    ans = Collections.max(map.get(left));

                } else { // right is nearest - min
                    ans = Collections.min(map.get(right));
                }
            }

            writer.write(ans + "\n");
        }

        reader.close();
        writer.close();
    }

}