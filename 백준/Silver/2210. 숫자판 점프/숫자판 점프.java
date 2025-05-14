
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final int         SIZE          = 5; // 숫자판 크기
    private static final int         STEPS         = 6; // 숫자 수의 크기
    private static       int[][]     board         = new int[SIZE][SIZE]; // 숫자판
    private static       Set<String> uniqueNumbers = new HashSet<>(); // 중복을 피하기 위한 Set

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자판 입력 받기
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 시작점에서 DFS 탐색 시작
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                dfs(i, j, "", 0);
            }
        }

        // 결과 출력
        System.out.println(uniqueNumbers.size());
    }

    private static void dfs(int x, int y, String current, int step) {
        // 현재 숫자 추가
        current += board[x][y];

        // 6자리 수가 완성된 경우
        if (step == STEPS - 1) {
            uniqueNumbers.add(current);
            return;
        }

        // 4 방향으로 탐색 (상하좌우)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (Math.abs(dx) + Math.abs(dy) == 1) { // 상하좌우 이동만 허용
                    int newX = x + dx;
                    int newY = y + dy;

                    // 범위 체크
                    if (isInBounds(newX, newY)) {
                        dfs(newX, newY, current, step + 1);
                    }
                }
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }
}