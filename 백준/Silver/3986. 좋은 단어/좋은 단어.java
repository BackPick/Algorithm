import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br          = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw          = new BufferedWriter(new OutputStreamWriter(System.out));
        int            resultCount = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String           word  = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                resultCount++;
            }
        }
        System.out.println(resultCount);

    }
}