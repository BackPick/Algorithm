import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader         br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter         bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            if (X == 0) {
                Integer poll = pq.poll();
                if (poll == null) {
                    bw.write(0 + "\n");
                    continue;
                }
                bw.write(poll + "\n");
            } else {
                pq.offer(X);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}