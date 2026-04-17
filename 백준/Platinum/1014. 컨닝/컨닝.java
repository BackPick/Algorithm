import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static boolean[][] comp = new boolean[1024][1024];
    static int[] bitCount = new int[1024];

    static {
        for (int i = 0; i < 1024; i++) {
            bitCount[i] = Integer.bitCount(i);
            for (int j = 0; j < 1024; j++) {
                if ((i & j) == 0 && (i & (j << 1)) == 0 && (i & (j >> 1)) == 0) {
                    comp[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        if (firstLine == null) return;
        int C = Integer.parseInt(firstLine.trim());
        StringBuilder sb = new StringBuilder();

        while (C-- > 0) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;
            
            StringTokenizer st = new StringTokenizer(line.trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] broken = new int[M];
            for (int r = 0; r < N; r++) {
                String rowStr = br.readLine();
                while (rowStr != null && rowStr.trim().isEmpty()) {
                    rowStr = br.readLine();
                }
                rowStr = rowStr.trim();
                for (int c = 0; c < M; c++) {
                    if (rowStr.charAt(c) == 'x') {
                        broken[c] |= (1 << r);
                    }
                }
            }

            int maxMask = 1 << N;
            int[] dp = new int[maxMask];
            int[] nextDp = new int[maxMask];
            Arrays.fill(dp, -1);

            for (int mask = 0; mask < maxMask; mask++) {
                if ((mask & broken[0]) == 0) {
                    dp[mask] = bitCount[mask];
                }
            }

            int[] validMasks = new int[maxMask];
            for (int c = 1; c < M; c++) {
                int validCount = 0;
                for (int mask = 0; mask < maxMask; mask++) {
                    if (dp[mask] != -1) {
                        validMasks[validCount++] = mask;
                    }
                }

                Arrays.fill(nextDp, -1);
                for (int currMask = 0; currMask < maxMask; currMask++) {
                    if ((currMask & broken[c]) != 0) continue;

                    int maxPrev = -1;
                    boolean[] compCurr = comp[currMask];
                    for (int i = 0; i < validCount; i++) {
                        int prevMask = validMasks[i];
                        if (compCurr[prevMask]) {
                            if (dp[prevMask] > maxPrev) {
                                maxPrev = dp[prevMask];
                            }
                        }
                    }

                    if (maxPrev != -1) {
                        nextDp[currMask] = maxPrev + bitCount[currMask];
                    }
                }
                System.arraycopy(nextDp, 0, dp, 0, maxMask);
            }

            int ans = 0;
            for (int mask = 0; mask < maxMask; mask++) {
                if (dp[mask] > ans) {
                    ans = dp[mask];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}