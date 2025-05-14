
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw     = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int             n      = Integer.parseInt(br.readLine());
        int             result = 0;
        stack.clear();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > y) {
                result++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            stack.push(y);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                result++;
            }
            stack.pop();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}