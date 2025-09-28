import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] dp;
    static boolean[][] inStack;
    static boolean infinite = false;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int dfs(int r, int c){
        if(infinite) return 0;
        if(r < 0 || r >= N || c < 0 || c >= M) return 0;
        if(board[r][c] == 'H') return 0;
        if(dp[r][c] != -1) return dp[r][c];
        if(inStack[r][c]) { infinite = true; return 0; }
        inStack[r][c] = true;
        int step = board[r][c] - '0';
        int best = 0;
        for(int k = 0; k < 4; k++){
            int nr = r + dr[k] * step;
            int nc = c + dc[k] * step;
            int val = 1 + dfs(nr, nc);
            if(infinite) { inStack[r][c] = false; return 0; }
            if(val > best) best = val;
        }
        inStack[r][c] = false;
        dp[r][c] = best;
        return best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][];
        for(int i = 0; i < N; i++) board[i] = br.readLine().trim().toCharArray();
        dp = new int[N][M];
        inStack = new boolean[N][M];
        IntStream.range(0, N).forEach(i -> Arrays.fill(dp[i], -1));
        int ans = dfs(0, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(infinite) bw.write("-1\n"); else bw.write(String.valueOf(ans) + "\n");
        bw.flush();
    }
}
