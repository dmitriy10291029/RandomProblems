package org.example.Yandex.BackendSchool.Contest1;

import java.util.Scanner;

public class Task1 {
    public static boolean checkName(String name) {
        if (name.length() < 8) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;

        for (char ch : name.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else {
                return false;
            }
            if (hasDigit && hasUpper && hasLower) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (checkName(scanner.next())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
