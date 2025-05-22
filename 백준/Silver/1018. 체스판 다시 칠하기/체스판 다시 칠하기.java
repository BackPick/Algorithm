import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        // 모든 8x8 위치 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countToFix(i, j));
            }
        }

        System.out.println(min);
    }

    // 시작점 (x, y)에서 8x8 체스판으로 고치는 최소 칠하기 횟수
    static int countToFix(int x, int y) {
        int count1 = 0; // W로 시작
        int count2 = 0; // B로 시작

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expected1 = ((i + j) % 2 == 0) ? 'W' : 'B'; // W 시작 체스판
                char expected2 = ((i + j) % 2 == 0) ? 'B' : 'W'; // B 시작 체스판

                char current = board[x + i][y + j];

                if (current != expected1) count1++;
                if (current != expected2) count2++;
            }
        }

        return Math.min(count1, count2);
    }
}
