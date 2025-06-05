

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int  n = Integer.parseInt(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        int  t = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        int count = 0;

        for (int i = 0; i < t; i++) {
            Long giant = pq.poll();

            if (giant == null) {
                break;
            }

            // 만약 센티가 더 커질 경우
            if (h > giant) {
                pq.offer(giant);
                break;
                // 거인이 더 클 경우
            } else {
                long foldGiant = 0L;
                if (giant == 1L) {
                    foldGiant = giant;
                } else {
                    foldGiant = giant / 2;
                }
                pq.offer(foldGiant);
                count++;
            }
        }

        if (pq.peek() < h) {
            bw.write("YES\n");
            bw.write(count + "");
        } else {
            bw.write("NO\n");
            bw.write(pq.peek() + "");
        }
        bw.flush();

    }
}
