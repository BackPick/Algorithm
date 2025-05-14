import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final String PUSH_FRONT = "push_front";
    private static final String PUSH_BACK = "push_back";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case PUSH_FRONT:
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case PUSH_BACK:
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case POP_FRONT:
                    appendResult(sb, deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case POP_BACK:
                    appendResult(sb, deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case SIZE:
                    sb.append(deque.size()).append('\n');
                    break;
                case EMPTY:
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case FRONT:
                    appendResult(sb, deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case BACK:
                    appendResult(sb, deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void appendResult(StringBuilder sb, int value) {
        sb.append(value).append('\n');
    }
}