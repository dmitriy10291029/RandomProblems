package org.example.Yandex.CodeRun.Task436;

import java.io.*;
import java.util.*;

public class Main {
    public static class Task implements Comparable<Task> {
        int deadline;
        int stress;
        boolean isComplete;

        Task(int deadline, int stress) {
            this.deadline = deadline;
            this.stress = stress;
            isComplete = false;
        }

        public boolean isComplete() {
            return isComplete;
        }

        public void setComplete(boolean complete) {
            isComplete = complete;
        }

        @Override
        public int compareTo(Task other) {
            return other.stress - this.stress;
        }

        @Override
        public String toString() {
            return "(" + deadline + " " + stress + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int d = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            tasks[i] = new Task(d, w);
        }
        Arrays.sort(tasks);
        TreeSet<Integer> freeDays = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            freeDays.add(i);
        }

        for (Task task : tasks) {
            if (freeDays.contains(task.deadline)) {
                freeDays.remove(task.deadline);
                task.setComplete(true);

            } else {
                Integer dayForComplete = freeDays.lower(task.deadline);
                if (dayForComplete != null) {
                    freeDays.remove(dayForComplete);
                    task.setComplete(true);
                } // else task can't be completed
            }
        }

        long totalStress = 0;

        for (Task task : tasks) {
            if (!task.isComplete) {
                totalStress += task.stress;
            }
        }

        writer.write(totalStress + "\n");

        reader.close();
        writer.close();
    }
}

