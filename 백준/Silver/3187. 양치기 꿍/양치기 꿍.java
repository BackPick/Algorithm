
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final char EMPTY = '.';
    private static final char WALL  = '#';
    private static final char WOLF  = 'v';
    private static final char SHEEP = 'k';

    private static int R, C;
    private static char[][]    grid;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] dimensions = br.readLine()
                .split(" ");
        R = Integer.parseInt(dimensions[0]);
        C = Integer.parseInt(dimensions[1]);

        grid    = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine()
                    .toCharArray();
        }

        int totalSheep  = 0;
        int totalWolves = 0;

        // 각 영역을 DFS로 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != WALL && !visited[i][j]) {
                    int[] result = dfs(i, j);
                    if (result[0] > result[1]) {
                        totalSheep += result[0]; // 양이 더 많으면 양만 살아남음
                    } else {
                        totalWolves += result[1]; // 늑대가 더 많거나 같으면 늑대만 살아남음
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(totalSheep + " " + totalWolves);
    }

    private static int[] dfs(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y] || grid[x][y] == WALL) {
            return new int[]{0, 0}; // 양과 늑대 수 반환
        }

        visited[x][y] = true;
        int sheepCount = 0;
        int wolfCount  = 0;

        if (grid[x][y] == SHEEP) {
            sheepCount++;
        } else if (grid[x][y] == WOLF) {
            wolfCount++;
        }

        // 상하좌우로 DFS 탐색
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int   newX   = x + dir[0];
            int   newY   = y + dir[1];
            int[] counts = dfs(newX, newY);
            sheepCount += counts[0];
            wolfCount += counts[1];
        }

        return new int[]{sheepCount, wolfCount};
    }
}
