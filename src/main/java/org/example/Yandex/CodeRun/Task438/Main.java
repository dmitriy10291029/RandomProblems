package org.example.Yandex.CodeRun.Task438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] spells = new char[3][];

        for (int i = 0; i < 3; i++) {
            spells[i] = reader.readLine().toCharArray();
        }

        ArrayList<Character>[] letters = new ArrayList[3];
        ArrayList<Integer>[] amounts = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            letters[i] = new ArrayList<Character>();
            amounts[i] = new ArrayList<Integer>();

            var spell = spells[i];
            //System.out.println(Arrays.toString(spell));
            for (int j = 0; j < spell.length; ) {
                char curr = spell[j];
                int amount = 0;
                while (j < spell.length && spell[j] == curr) {
                    j++;
                    amount++;
                }
                letters[i].add(curr);
                amounts[i].add(amount);
                //System.out.print(curr);
                //System.out.println(" " + amount);
            }
            //System.out.println();
        }

        boolean isPossible = true;
        for (int i = 1; i < 3; i++) {
            if (letters[i].size() != letters[0].size()) {
                isPossible = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isPossible) {
            loop:
            for (int i = 0; i < letters[0].size(); i++) {
                char curr = letters[0].get(i);
                for (int j = 1; j < 3; j++) {
                    if (letters[j].get(i) != curr) {
                        isPossible = false;
                        break loop;
                    }
                }
                int[] temp = new int[]{amounts[0].get(i), amounts[1].get(i), amounts[2].get(i)};
                Arrays.sort(temp);
                int average = temp[1];

                for (int j = 0; j < average; j++) {
                    sb.append(curr);
                }
            }
        }

        if (isPossible) {
            writer.write(sb.toString());
        } else {
            writer.write("IMPOSSIBLE");
        }

        reader.close();
        writer.close();
    }

}