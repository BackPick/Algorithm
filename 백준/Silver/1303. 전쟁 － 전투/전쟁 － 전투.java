import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int whitePower = 0;
        int bluePower = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        whitePower += size * size;
                    } else {
                        bluePower += size * size;
                    }
                }
            }
        }

        System.out.println(whitePower + " " + bluePower);
    }

    static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == team) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
