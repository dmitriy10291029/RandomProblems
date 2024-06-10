package org.example.Yandex.BackendSchool.Contest2;

import java.util.HashMap;
import java.util.Scanner;

public class Task1 {
    public enum Figure {empty, first, second}

    public static class Grid {
        private final HashMap<Long, Figure> map = new HashMap<>();

        public Grid() {}

        public Figure getFigure(long x, long y) {
            Long pair = getPair(x, y);
            if (map.containsKey(pair)) {
                return map.get(getPair(x, y));
            }
            return Figure.empty;
        }

        public void setFigure(long x, long y, Figure fig) {
            if (fig != Figure.empty) {
                map.put(getPair(x, y), fig);
            }
        }

        private long getPair(long x, long y) {
            return (y << 30) + x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        int n = scanner.nextInt();
        for (int move = 1; move <= n; move++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            Figure fig = move % 2 == 1? Figure.first : Figure.second;
            grid.setFigure(x, y, fig);

            long hoz = 0, ver = 0, d1 = 0, d2 = 0;

            for (int i = -4; i <= 4; i++) {
                hoz = grid.getFigure(x + i, y) == fig ? hoz + 1 : 0;
                ver = grid.getFigure(x, y + i) == fig ? ver + 1 : 0;
                d1  = grid.getFigure(x + i, y + i) == fig ?  d1 + 1 : 0;
                d2  = grid.getFigure(x - i, y + i) == fig ?  d2 + 1 : 0;

                if (hoz == 5 || ver == 5 || d1 == 5 || d2 == 5) {
                    if (move != n) {
                        System.out.println("Inattention");
                    } else if (fig == Figure.first) {
                        System.out.println("First");
                    } else {
                        System.out.println("Second");
                    }
                    return;
                }
            }
        }
        System.out.println("Draw");
    }
}
