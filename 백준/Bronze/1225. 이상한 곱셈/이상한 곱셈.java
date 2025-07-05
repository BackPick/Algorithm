import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        String A = scanner.next();
        String B = scanner.next();

        long sum = 0;

        // 각 자릿수를 전부 곱해서 더한다요
        for (int i = 0; i < A.length(); i++) {
            int digitA = A.charAt(i) - '0'; // 문자 → 숫자 변환
            for (int j = 0; j < B.length(); j++) {
                int digitB = B.charAt(j) - '0';
                sum += (long) digitA * digitB;
            }
        }

        System.out.println(sum);
    }
}
