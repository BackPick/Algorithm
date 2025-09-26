import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int L = S.length();
        int N = Integer.parseInt(br.readLine().trim());
        String[] words = new String[N];
        int[][] wfreq = new int[N][26];
        int[] wlen = new int[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().trim();
            wlen[i] = words[i].length();
            for (char c : words[i].toCharArray()) wfreq[i][c - 'a']++;
        }
        final int INF = 1_000_000_000;
        int[] dp = new int[L + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int pos = 0; pos < L; pos++) {
            if (dp[pos] == INF) continue;
            for (int wi = 0; wi < N; wi++) {
                int len = wlen[wi];
                if (pos + len > L) continue;
                int[] sf = new int[26];
                for (int k = 0; k < len; k++) sf[S.charAt(pos + k) - 'a']++;
                boolean ok = true;
                for (int c = 0; c < 26; c++) {
                    if (sf[c] != wfreq[wi][c]) { ok = false; break; }
                }
                if (!ok) continue;
                int cost = 0;
                String w = words[wi];
                for (int k = 0; k < len; k++) if (w.charAt(k) != S.charAt(pos + k)) cost++;
                int np = pos + len;
                if (dp[np] > dp[pos] + cost) dp[np] = dp[pos] + cost;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (dp[L] >= INF) bw.write("-1\n"); else bw.write(String.valueOf(dp[L]) + "\n");
        bw.flush();
    }
}
