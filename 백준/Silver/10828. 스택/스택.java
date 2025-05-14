import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int            n     = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st    = new StringTokenizer(br.readLine());
            String          order = st.nextToken();
            switch (order) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.isEmpty() ? "-1\n" : stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case "top":
                    bw.write(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
                    break;
            }
            bw.flush();
        }
    }


}

