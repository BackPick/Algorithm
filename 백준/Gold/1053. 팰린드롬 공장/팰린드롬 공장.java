import java.io.*;
import java.util.*;

public class Main {
    static int solveDP(char[] s) {
        int n = s.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s[i] == s[j]) dp[i][j] = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                else {
                    int a = dp[i + 1][j] + 1;
                    int b = dp[i][j - 1] + 1;
                    int c = ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0) + 1;
                    dp[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine().trim();
        char[] arr = s.toCharArray();
        int n = arr.length;

        int best = solveDP(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] t = arr.clone();
                char tmp = t[i];
                t[i] = t[j];
                t[j] = tmp;
                best = Math.min(best, 1 + solveDP(t));
            }
        }

        bw.write(String.valueOf(best));
        bw.newLine();
        bw.flush();
    }
}
