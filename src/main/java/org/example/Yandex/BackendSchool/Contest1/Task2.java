package org.example.Yandex.BackendSchool.Contest1;

import java.util.Scanner;

public class Task2 {
    private static class Node {
        public char ch;
        public Node next;
        public Node prev;

        public Node() { }

        public Node(char ch, Node prev, Node next) {
            this.ch = ch;
            this.next = next;
            this.prev = prev;
        }

        public Node remove() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            return prev;
        }

        public Node insert(char newChar) {
            Node newNode = new Node(newChar, this, next);
            if (next != null) {
                next.prev = newNode;
            }
            return next = newNode;
        }

        @Override
        public String toString() {
            Node curr = this;
            StringBuilder sb = new StringBuilder();

            while (curr != null) {
                sb.append(curr.ch);
                curr = curr.next;
            }

            return sb.toString();
        }
    }

    public static String getUserText(String log) {
        Node fakeRoot = new Node();
        Node current = fakeRoot;

        char[] logArray = log.toCharArray();
        for (int i = 0; i < logArray.length; i++) {
            char ch = logArray[i];
            if (ch != '<') {
                current = current.insert(ch);
                continue;
            }

            ch = logArray[++i];
            StringBuilder commandSB = new StringBuilder();
            while (ch != '>') {
                commandSB.append(ch);
                ch = logArray[++i];
            }

            switch (commandSB.toString()) {
                case "delete" -> {
                    if (current.next != null) {
                        current.next.remove();
                    }
                }
                case "bspace" -> {
                    if (current != fakeRoot) {
                        current = current.remove();
                    }
                }
                case "left" -> {
                    if (current != fakeRoot) {
                        current = current.prev;
                    }
                }
                case "right" -> {
                    if (current.next != null) {
                        current = current.next;
                    }
                }
            }

        }

        return fakeRoot.next == null ? "" : fakeRoot.next.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.next();
        String log = scanner.next();

        if (task.equals(getUserText(log))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}