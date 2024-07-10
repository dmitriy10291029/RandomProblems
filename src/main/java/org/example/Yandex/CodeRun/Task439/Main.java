package org.example.Yandex.CodeRun.Task439;

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

        char[] text = reader.readLine().toCharArray();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i < text.length; i++) {
            char c1 = text[i - 1];
            char c2 = text[i];

            if (c1 != ' ' && c2 != ' ') {
                String key = "" + c1 + c2;
                map.merge(key, 1, Integer::sum);
            }
        }

        String answer = map.entrySet()
                .stream()
                .max((entry1, entry2) -> {
                    int valueComparison = entry1.getValue().compareTo(entry2.getValue());
                    if (valueComparison == 0) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return valueComparison;
                })
                .get()
                .getKey();

        writer.write(answer);

        reader.close();
        writer.close();
    }

}
