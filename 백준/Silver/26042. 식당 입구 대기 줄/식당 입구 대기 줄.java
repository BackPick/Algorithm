

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int             n  = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> lineQueue   = new ArrayDeque<>();
        int            maxCount    = 0;
        int            lastStudent = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int student = Integer.parseInt(st.nextToken());
                lineQueue.add(student);
            } else if (type == 2) {
                lineQueue.poll(); 
            }

            int currentCount = lineQueue.size();
            if (currentCount > maxCount) {
                maxCount    = currentCount;
                lastStudent = lineQueue.peekLast(); 
            } else if (currentCount == maxCount) {
                if (!lineQueue.isEmpty() && lineQueue.peekLast() < lastStudent) {
                    lastStudent = lineQueue.peekLast();
                }
            }
        }
        bw.write(maxCount + " " + lastStudent);

        bw.flush();
        bw.close();
        br.close();
    }
}