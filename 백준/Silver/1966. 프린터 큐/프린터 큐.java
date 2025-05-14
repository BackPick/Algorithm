import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int             t;
    static int             n;
    static int             m;
    static Queue<Integer>  queue;
    static Queue<Integer>  indexQueue;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n  = Integer.parseInt(st.nextToken());
            m  = Integer.parseInt(st.nextToken());

            queue      = new LinkedList<>();
            indexQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
                indexQueue.offer(j);
            }

            int count = 1;
            while (!queue.isEmpty()) {
                int max          = Collections.max(queue);
                int current      = queue.poll();
                int currentIndex = indexQueue.poll();

                if (current == max) {
                    if (currentIndex == m) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                } else {
                    queue.offer(current);
                    indexQueue.offer(currentIndex);
                }


            }

        }

    }
}