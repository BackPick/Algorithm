
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.length() == 1 && line.charAt(0) == '.') {
                break;
            }
            bw.write(lineAssertion(line) ? "yes\n" : "no\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean lineAssertion(String line) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = line.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}