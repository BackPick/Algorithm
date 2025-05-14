import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K; // 가로 길이, 세로 길이, 배추 개수
    static int[][] field; // 배추밭
    static boolean[][] visited; // 방문 기록
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1; // 배추가 심어져 있는 곳은 1
            }

            int wormCount = 0; // 필요한 배추흰지렁이 개수

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        // DFS 호출
                        dfs(i, j);
                        wormCount++;
                    }
                }
            }

            sb.append(wormCount).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 배추를 방문 처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) { // 배열 범위 체크
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny); // 인접한 배추가 있으면 DFS 진행
                }
            }
        }
    }
}
