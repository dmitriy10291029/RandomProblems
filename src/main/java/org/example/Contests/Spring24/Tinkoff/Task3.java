package org.example.Contests.Spring24.Tinkoff;

// print sorted directories

import java.io.InputStream;
import java.util.Scanner;
import java.util.TreeMap;

public class Task3 {
    public static class Node {
        public int level;
        public TreeMap<String, Node> internal;

        public Node(int level) {
            this.level = level;
            internal = new TreeMap<>();
        }

        public Node add(String name) {
            Node newNode = new Node(level + 1);
            internal.put(name, newNode);
            return newNode;
        }

        public Node get(String name) {
            return internal.get(name);
        }

        public boolean contains(String name) {
            return internal.containsKey(name);
        }

        public void print() {
            for (var entry : internal.entrySet()) {
                for (int i = 0; i < level; i++){
                    System.out.print("  ");
                }
                System.out.println(entry.getKey());
                entry.getValue().print();
            }
        }
    }

    public static void printSortedAndFormatted(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int n = scanner.nextInt();

        Node root = new Node(1);
        String rootName = "root";

        for (int j = 0; j < n; j++) {
            var path = scanner.next().split("/");
            if (path.length == 1) {
                rootName = path[0];
            } else {
                Node last = root;
                for (int i = 1; i < path.length; i++) {
                    if (last.contains(path[i])) {
                        last = last.get(path[i]);
                    } else {
                        last = last.add(path[i]);
                    }
                }
            }
        }
        System.out.println(rootName);
        root.print();
    }

    public static void main(String[] args) {
        printSortedAndFormatted(System.in);
    }
}
