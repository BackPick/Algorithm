
import java.util.Scanner;

public class Main {
    //    오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다.
    //    아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
    //    오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다.
    //    재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자.
    //    아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
    //    피보나치 수 재귀호출 의사 코드는 다음과 같다.
    public static void main(String[] args) {
        //사전 작업
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        //값으로 받을 변수 n
        int n = sc.nextInt();
        sc.close();

        // 조건 - 5 <= n <= 40
        if ((n < 5) || (n > 40)) {
            return;
        }
        int i = fibonacci(n);
        System.out.println(sb.append(i + " " + (n - 2)));
    }

    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
