
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        String line = br.readLine();

        Stack<Character> stack   = new Stack<>();
        Stack<Integer>   values  = new Stack<>();
        boolean          isValid = true;

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                values.push(-1);
            } else if (c == ')' || c == ']') {
                int tempSum = 0;

                while (!values.isEmpty() && values.peek() != -1) {
                    tempSum += values.pop();
                }
                if (values.isEmpty() || stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char open = stack.pop();
                values.pop();

                if ((c == ')' && open != '(') || (c == ']' && open != '[')) {
                    isValid = false;
                    break;
                }

                int multiply = (c == ')') ? 2 : 3;
                values.push(tempSum == 0 ? multiply : tempSum * multiply);
            }
        }
        if (!isValid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            int result = 0;
            while (!values.isEmpty()) {
                result += values.pop();
            }
            System.out.println(result);
        }

    }
}
