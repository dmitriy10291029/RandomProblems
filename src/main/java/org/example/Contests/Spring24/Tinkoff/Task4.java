package org.example.Contests.Spring24.Tinkoff;

// rotate matrix 2

import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static class Swap {
        final int A,B,C,D;
        public Swap(int a, int b, int c, int d) {A=a;B=b;C=c;D=d;}
    }

    public static ArrayList<Swap> rightRotate(int n) {
        ArrayList<Swap> operations = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            int _i = n - i - 1;
            for (int j = i; j < n - i - 1; j++){
                int _j = n - j - 1;
                operations.add(new Swap(_j, i,  i,  j));
                operations.add(new Swap(_j, i,  j, _i));
                operations.add(new Swap(_j, i, _i, _j));
            }
        }
        return operations;
    }

    public static ArrayList<Swap> leftRotate(int n) {
        ArrayList<Swap> operations = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            int _i = n - i - 1;
            for (int j = i; j < n - i - 1; j++){
                int _j = n - j - 1;
                operations.add(new Swap(i, j,  j, _i));
                operations.add(new Swap(j, _i, _i, _j));
                operations.add(new Swap(_i, _j, _j,  i));
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String dir = scanner.next();
        ArrayList<Swap> operations;
        if ("R".equals(dir)) {
            operations = rightRotate(n);
            System.out.println(operations.size());
            for (var o : operations) {
                System.out.printf("%d %d %d %d%n", o.A, o.B, o.C, o.D);
            }
        } else if ("L".equals(dir)) {
            operations = leftRotate(n);
            System.out.println(operations.size());
            for (var o : operations) {
                System.out.printf("%d %d %d %d%n", o.A, o.B, o.C, o.D);
            }
        }
    }
}
