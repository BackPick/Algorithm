import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int L = s.length();
        int ans = L;
        for (int p = 1; p <= M; p++) {
            int cost = 0;
            for (int i = 0; i < p; i++) {
                int[] cnt = new int[4];
                int csize = 0;
                for (int j = i; j < L; j += p) {
                    csize++;
                    char ch = s.charAt(j);
                    if (ch == 'A') cnt[0]++;
                    else if (ch == 'C') cnt[1]++;
                    else if (ch == 'G') cnt[2]++;
                    else cnt[3]++;
                }
                int maxf = Math.max(Math.max(cnt[0], cnt[1]), Math.max(cnt[2], cnt[3]));
                cost += csize - maxf;
            }
            ans = Math.min(ans, cost);
        }
        System.out.println(ans);
    }
}
