import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();              // 사람 수
        int[] count = new int[N];          // 각 사람이 기억하는 큰 사람 수
        int[] result = new int[N];         // 최종 줄 선 순서 (0이면 빈 자리)

        for (int i = 0; i < N; i++) {
            count[i] = sc.nextInt();       // i번째 → 키가 i+1인 사람
        }

        for (int i = 0; i < N; i++) {
            int taller = count[i];         // 왼쪽에 있어야 하는 키 큰 사람 수
            int height = i + 1;            // 현재 사람의 키 (1부터 시작)
            int pos = 0;
            int emptyCount = 0;

            // result 배열에서 올바른 자리 찾기
            while (pos < N) {
                if (result[pos] == 0) { // 빈 자리만 카운트
                    if (emptyCount == taller) {
                        break;
                    }
                    emptyCount++;
                }
                pos++;
            }

            result[pos] = height;
        }

        // 결과 출력
        for (int h : result) {
            System.out.print(h + " ");
        }
    }
}
