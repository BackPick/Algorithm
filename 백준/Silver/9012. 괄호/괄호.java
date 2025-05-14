import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 테스트 케이스의 수
        
        for (int i = 0; i < t; i++) {
            String target = scanner.next();
            System.out.println(parenthesisVerification(target) ? "YES" : "NO");
        }
        
        scanner.close();
    }

    public static boolean parenthesisVerification(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}