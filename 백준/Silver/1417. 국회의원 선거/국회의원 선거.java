
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq    = new PriorityQueue<>(Collections.reverseOrder());
        int                    n     = Integer.parseInt(br.readLine());
        int                    DASOM = Integer.parseInt(br.readLine());
        int                    count = 0;

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 0; i < n - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        while (DASOM <= pq.peek()) {
            int poll = pq.poll();
            count++;
            DASOM++;
            poll--;
            if (poll > 0) {
                pq.offer(poll);
            }

        }
        System.out.println(count);
    }
}