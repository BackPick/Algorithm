import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] mh = {0, 0, 1, -1};
        int[] mw = {1, -1, 0, 0};
        
        int[] hh = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] hw = {-1, 1, -2, 2, -2, 2, -1, 1};

        int[][][] dist = new int[h][w][k + 1];

        Arrays.stream(dist).forEach(
            arr2D -> Arrays.stream(arr2D).forEach(
                arr1D -> Arrays.fill(arr1D, -1)
            )
        );

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        dist[0][0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curH = curr[0];
            int curW = curr[1];
            int curK = curr[2];

            if (curH == h - 1 && curW == w - 1) {
                bw.write(dist[curH][curW][curK] + "\n");
                bw.flush();
                br.close();
                bw.close();
                return;
            }

            int nextMoveCount = dist[curH][curW][curK] + 1;

            for (int i = 0; i < 4; i++) {
                int nh = curH + mh[i];
                int nw = curW + mw[i];

                if (nh >= 0 && nh < h && nw >= 0 && nw < w && grid[nh][nw] == 0) {
                    if (dist[nh][nw][curK] == -1) {
                        dist[nh][nw][curK] = nextMoveCount;
                        queue.add(new int[]{nh, nw, curK});
                    }
                }
            }

            if (curK < k) {
                for (int i = 0; i < 8; i++) {
                    int nh = curH + hh[i];
                    int nw = curW + hw[i];

                    if (nh >= 0 && nh < h && nw >= 0 && nw < w && grid[nh][nw] == 0) {
                        if (dist[nh][nw][curK + 1] == -1) {
                            dist[nh][nw][curK + 1] = nextMoveCount;
                            queue.add(new int[]{nh, nw, curK + 1});
                        }
                    }
                }
            }
        }

        bw.write("-1\n");
        bw.flush();
        br.close();
        bw.close();
    }
}