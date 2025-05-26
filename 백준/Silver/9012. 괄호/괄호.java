
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean          isVPS = true;

            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    // ) 를 받았을 때 stack이 비어있을 경우
                    if (stack.isEmpty()) {
                        // stack 이 비어있지 않 경우
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                isVPS = false;
            }
            bw.write(isVPS ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
    }
}
