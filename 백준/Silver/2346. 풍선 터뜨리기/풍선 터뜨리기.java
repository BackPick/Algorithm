import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        Deque<int[]>    deque = new ArrayDeque<>();
        StringTokenizer st    = new StringTokenizer(br.readLine());

        sb.append("1 ");
        int move = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= num; i++) {
            deque.addLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                int[] next = deque.pollFirst();
                move = next[1];
                sb.append(next[0])
                        .append(" ");

            } else {
                for (int i = move; i < -1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                int[] next = deque.pollLast();
                move = next[1];
                sb.append(next[0])
                        .append(" ");
            }
        }
        System.out.println(sb);

    }
}