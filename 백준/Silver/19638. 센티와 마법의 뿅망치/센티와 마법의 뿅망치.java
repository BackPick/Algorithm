import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int  n     = Integer.parseInt(st.nextToken());
        Long centi = Long.valueOf(st.nextToken());
        int  t     = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.offer(Long.valueOf(br.readLine()));
        }

        int count = 0;
        for (int i = 0; i < t; i++) {
            Long giant = pq.poll();

            if (giant == null) {
                break;
            }

            if (centi > giant) {
                pq.offer(giant);
                break;
            } else {
                long foldGiant = 0L;
                if (giant == 1L) {
                    foldGiant = 1L;
                } else {
                    foldGiant = giant / 2;
                }
                pq.offer(foldGiant);
                count++;
            }
        }
        if (pq.peek() < centi) {
            bw.write("YES");
            bw.newLine();
            bw.write(String.valueOf(count));
        } else {
            bw.write("NO");
            bw.newLine();
            bw.write(String.valueOf(pq.peek()));
        }

        bw.flush();

    }
}