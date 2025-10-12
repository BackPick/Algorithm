import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String O = br.readLine();
        String N = br.readLine();
        int m = O.length(), n = N.length();
        final int INF = 1_000_000_000;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], INF);
        dp[m][n] = 0;
        for (int j = n - 1; j >= 0; j--) dp[m][j] = 1;
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = INF;
            int suffixMin = INF;
            for (int j = n; j >= 0; j--) {
                int val;
                if (j == n) {
                    val = INF;
                } else {
                    val = (O.charAt(i) == N.charAt(j)) ? dp[i + 1][j + 1] : INF;
                    val = Math.min(val, 1 + suffixMin);
                }
                dp[i][j] = val;
                suffixMin = Math.min(suffixMin, dp[i][j]);
            }
        }
        int ans = dp[0][0];
        if (ans >= INF) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
