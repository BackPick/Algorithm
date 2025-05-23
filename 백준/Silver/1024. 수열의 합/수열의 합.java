import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();  // 합
        int L = sc.nextInt();    // 최소 길이

        for (int len = L; len <= 100; len++) {
            // 수열의 합 공식: sum = (first + last) * len / 2
            // 이를 바꿔서, 첫 항 first를 구하면:
            // N = (2 * first + len - 1) * len / 2
            // -> first = (2 * N - len * (len - 1)) / (2 * len)

            long temp = 2 * N - len * (len - 1);
            if (temp < 0) continue;  // 음수면 만들 수 없음
            if (temp % (2 * len) != 0) continue;  // 나누어떨어지지 않으면 패스

            long start = temp / (2 * len);
            if (start < 0) continue;  // 음수면 안됨 (음이 아닌 정수)

            for (int i = 0; i < len; i++) {
                System.out.print((start + i) + " ");
            }
            System.out.println();
            return;
        }

        // 못 찾았으면 -1 출력
        System.out.println("-1");
    }
}
