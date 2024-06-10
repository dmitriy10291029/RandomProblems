package org.example.Contests.Spring24.Tinkoff;

// Oleg`s marks

import java.util.Scanner;

public class Task1 {
    public static boolean isMarkBad(int mark) {
        return mark == 2 || mark == 3;
    }

    public static int getMaxFives(int[] marks) {
        if (marks.length < 7) {
            return -1;
        }

        int badMarksN = 0;
        int fivesN = 0;
        int maxFivesN = -1;

        for (int i = 0; i < 7; ++i) {
            if (isMarkBad(marks[i])) {
                badMarksN++;
            } else if (marks[i] == 5) {
                fivesN++;
            }
        }
        if (badMarksN == 0) {
            maxFivesN = fivesN;
        }

        for (int pop = 0, push = 7; push < marks.length; pop++, push++) {
            if (isMarkBad(marks[pop])) {
                badMarksN--;
            } else if (marks[pop] == 5) {
                fivesN--;
            }

            if (isMarkBad(marks[push])) {
                badMarksN++;
            } else if (marks[push] == 5) {
                fivesN++;
            }

            if (badMarksN == 0 && maxFivesN < fivesN) {
                maxFivesN = fivesN;
            }
        }

        return maxFivesN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[scanner.nextInt()];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = scanner.nextInt();
        }
        System.out.println(getMaxFives(marks));
    }
}
