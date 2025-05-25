import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행의 개수
        int M = sc.nextInt(); // 열의 개수
        sc.nextLine(); // 개행 문자 제거

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray(); // 문자열을 문자 배열로 저장
        }

        int maxSize = 1; // 최소 정사각형 크기 (1x1)

        // 모든 시작점 (i, j)에 대해 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가능한 최대 정사각형 크기까지 탐색
                for (int size = 1; i + size < N && j + size < M; size++) {
                    // 네 꼭짓점 숫자가 모두 같은지 확인
                    if (map[i][j] == map[i][j + size] &&
                        map[i][j] == map[i + size][j] &&
                        map[i][j] == map[i + size][j + size]) {
                        int area = (size + 1) * (size + 1); // 정사각형 넓이 계산
                        if (area > maxSize) {
                            maxSize = area; // 최대 넓이 갱신
                        }
                    }
                }
            }
        }

        System.out.println(maxSize); // 결과 출력
    }
}
