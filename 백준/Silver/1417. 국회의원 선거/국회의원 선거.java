

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int n     = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        if (n == 1) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (priorityQueue.peek() >= dasom) {
            Integer voter = priorityQueue.poll();
            count++;
            voter--;
            dasom++;
            if (voter > 0) {
                priorityQueue.offer(voter);
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}