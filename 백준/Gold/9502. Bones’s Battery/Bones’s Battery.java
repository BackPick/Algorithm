import java.io.*;
import java.util.*;

public class Main {
    // 거리는 더하다보면 int 범위 넘을 수 있으니 넉넉하게 long
    static final long INF = 1_000_000_000_000_000L;
    static int N, K, M;
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); // 최대 충전 횟수
            M = Integer.parseInt(st.nextToken());

            // 거리 배열 초기화
            dist = new long[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());

                // 양방향 도로, 더 짧은 경로가 들어오면 갱신
                if (dist[u][v] > w) {
                    dist[u][v] = w;
                    dist[v][u] = w;
                }
            }

            // 플로이드로 모든 지점 간 실제 최단 거리 미리 구해놓기
            // N이 100이라서 3중 for문 돌려도 충분함
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (dist[i][k] == INF) continue;
                    for (int j = 0; j < N; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            // 이분 탐색
            // 배터리 용량을 mid로 잡고, K번 안에 갈 수 있는지 확인
            long left = 0;
            long right = 200_000_000_000_000L; // 대충 큰 값
            long ans = right;

            while (left <= right) {
                long mid = (left + right) / 2;

                if (solve(mid)) {
                    // 가능하면 배터리 용량 더 줄여보기
                    ans = mid;
                    right = mid - 1;
                } else {
                    // 불가능하면 용량 늘려야 함
                    left = mid + 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    // 배터리 용량이 limit일 때, K번 이하 충전으로 모든 곳 이동 가능한지 체크
    static boolean solve(long limit) {
        int[][] cost = new int[N][N];

        // limit보다 거리가 짧으면 1번 충전(1칸 이동)으로 침
        // 아니면 못가는 길(무한대)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) cost[i][j] = 0;
                else if (dist[i][j] <= limit) cost[i][j] = 1;
                else cost[i][j] = 1000; // K가 100이하니까 적당히 큰 수
            }
        }

        // 플로이드 한번 더 돌려서 최소 충전 횟수
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        // 모든 쌍에 대해 K번 이하로 갈 수 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cost[i][j] > K) return false; // 하나라도 안되면 탈락
            }
        }
        return true;
    }
}