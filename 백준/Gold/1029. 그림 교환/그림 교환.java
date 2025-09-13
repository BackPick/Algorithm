import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[][][] dp;
    static boolean[][][] vis;
    static int ans = 1;

    static void dfs(int mask, int last, int price) {
        if (vis[mask][last][price]) return;
        vis[mask][last][price] = true;
        int cur = dp[mask][last][price];
        ans = Math.max(ans, cur);
        for (int nxt = 0; nxt < N; nxt++) {
            if ((mask & (1 << nxt)) != 0) continue;
            int c = cost[last][nxt];
            if (c >= price) {
                int nmask = mask | (1 << nxt);
                if (dp[nmask][nxt][c] < cur + 1) {
                    dp[nmask][nxt][c] = cur + 1;
                    dfs(nmask, nxt, c);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine().trim());
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                cost[i][j] = line.charAt(j) - '0';
            }
        }
        dp = new int[1 << N][N][10];
        vis = new boolean[1 << N][N][10];
        dp[1][0][0] = 1;
        dfs(1, 0, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
