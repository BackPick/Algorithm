

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD  = 1_000_000_007;
    static final int NONE = 10; // 아직 공차가 결정되지 않은 상태

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[A + 2][10][11];
        long[][][] next = new long[A + 2][10][11];

        // 첫 자리 초기화 (0 제외)
        for (int d = 1; d <= 9; d++) {
            dp[1][d][NONE] = 1;
        }

        for (int pos = 1; pos < N; pos++) {
            // 다음 단계 초기화
            for (int seg = 0; seg <= A; seg++)
                for (int dig = 0; dig < 10; dig++)
                    Arrays.fill(next[seg][dig], 0);

            for (int seg = 1; seg <= A; seg++) {
                for (int last = 0; last < 10; last++) {
                    for (int state = 0; state < 11; state++) {
                        long ways = dp[seg][last][state];
                        if (ways == 0) continue;

                        for (int x = last; x < 10; x++) { // non-decreasing
                            if (state == NONE) {
                                int newDiff = x - last;
                                next[seg][x][newDiff] = (next[seg][x][newDiff] + ways) % MOD;
                            } else {
                                int d = state;
                                if (x - last == d) {
                                    next[seg][x][d] = (next[seg][x][d] + ways) % MOD;
                                } else if (seg + 1 <= A) {
                                    next[seg + 1][x][NONE] = (next[seg + 1][x][NONE] + ways) % MOD;
                                }
                            }
                        }
                    }
                }
            }

            long[][][] temp = dp;
            dp = next;
            next = temp;
        }

        long result = 0;
        for (int last = 0; last < 10; last++)
            for (int state = 0; state < 11; state++)
                result = (result + dp[A][last][state]) % MOD;

        System.out.println(result);
    }
}
