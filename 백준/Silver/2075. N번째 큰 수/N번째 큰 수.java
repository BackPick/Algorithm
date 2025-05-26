
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st     = new StringTokenizer(br.readLine());
            int             tokens = st.countTokens();
            for (int j = 0; j < tokens; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (pq.size() < testCase) {
                    pq.offer(number);
                } else {
                    if (pq.peek() < number) {
                        pq.poll();
                        pq.offer(number);
                    }
                }
            }

        }
        bw.write(pq.peek() + "");
        bw.flush();

    }
}