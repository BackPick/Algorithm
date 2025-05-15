import java.util.Scanner;

public class Main {
    static int[] count0 = new int[41];  // 0이 출력되는 횟수
    static int[] count1 = new int[41];  // 1이 출력되는 횟수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 개수

        // 기본값 설정
        count0[0] = 1; count1[0] = 0;
        count0[1] = 0; count1[1] = 1;

        // DP 계산
        for (int i = 2; i <= 40; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        // 테스트 케이스 실행
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(count0[n] + " " + count1[n]);
        }
    }
}
