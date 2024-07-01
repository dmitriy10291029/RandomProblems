package org.example.Yandex.CodeRun.Task50;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();
        int ch;
        do {
            ch = reader.read();
            if (!currentWord.isEmpty() && (ch == -1 || Character.isWhitespace(ch))) {
                map.merge(currentWord.toString(), 1, Integer::sum);
                currentWord.setLength(0);
            } else {
                currentWord.append((char) ch);
            }
        } while (ch > -1);

        int max = map.values().stream().max(Integer::compareTo).get();

        String ans = map.entrySet().stream()
                .filter(a -> (a.getValue() == max))
                .map(Map.Entry::getKey)
                .min(String::compareTo)
                .get();

        writer.write(ans);

        reader.close();
        writer.close();
    }

}
