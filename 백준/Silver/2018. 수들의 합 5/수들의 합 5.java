import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        // 연속된 자연수의 합으로 나타낼 수 있는 경우를 찾는 반복문
        for (int m = 1; m * (m - 1) / 2 < num; m++) {
            // 연속된 자연수의 합을 표현할 수 있는 시작 값 k가 있는지 확인
            if ((num - m * (m - 1) / 2) % m == 0) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
