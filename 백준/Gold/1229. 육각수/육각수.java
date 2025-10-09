import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        List<Integer> H = new ArrayList<>();
        int n = 1;
        while (true) {
            int h = n * (2 * n - 1);
            if (h > N) break;
            H.add(h);
            n++;
        }
        boolean[] isHex = new boolean[N + 1];
        H.forEach(h -> isHex[h] = true);
        if (isHex[N]) {
            bw.write("1");
            bw.flush();
            return;
        }
        int L = H.size();
        boolean[] twoSum = new boolean[N + 1];
        List<Integer> twoList = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            for (int j = i; j < L; j++) {
                int s = H.get(i) + H.get(j);
                if (s <= N && !twoSum[s]) {
                    twoSum[s] = true;
                    twoList.add(s);
                }
            }
        }
        for (int h : H) if (N - h >= 0 && isHex[N - h]) {
            bw.write("2");
            bw.flush();
            return;
        }
        for (int h : H) if (N - h >= 0 && twoSum[N - h]) {
            bw.write("3");
            bw.flush();
            return;
        }
        if (N > 1791) {
            BitSet bs = new BitSet(N + 1);
            twoList.forEach(bs::set);
            for (int s : twoList) {
                int need = N - s;
                if (need >= 0 && bs.get(need)) {
                    bw.write("4");
                    bw.flush();
                    return;
                }
            }
            bw.write("4");
            bw.flush();
            return;
        } else {
            final int INF = 1_000_000_000;
            int[] dp = new int[N + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int coin : H) {
                for (int s = coin; s <= N; s++) {
                    if (dp[s - coin] + 1 < dp[s]) dp[s] = dp[s - coin] + 1;
                }
            }
            bw.write(String.valueOf(dp[N]));
            bw.flush();
            return;
        }
    }
}
