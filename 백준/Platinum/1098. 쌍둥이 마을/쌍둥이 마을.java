import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] X = new int[N];
        int[] Y = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int P = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] uArr = new int[45];
        int[] vArr = new int[45];
        int[] wArr = new int[45];
        int edgeCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist = Math.abs(X[i] - X[j]) + Math.abs(Y[i] - Y[j]);
                if (dist >= D) {
                    uArr[edgeCount] = i;
                    vArr[edgeCount] = j;
                    wArr[edgeCount] = dist;
                    edgeCount++;
                }
            }
        }

        int maxMask = (1 << (2 * N)) - 1;
        int[] dp = new int[maxMask + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < edgeCount; i++) {
            int u = uArr[i];
            int v = vArr[i];
            int w = wArr[i];
            int shiftU = 2 * u;
            int shiftV = 2 * v;
            int addMask = (1 << shiftU) + (1 << shiftV);

            for (int mask = maxMask; mask >= 0; mask--) {
                if (dp[mask] != Integer.MAX_VALUE) {
                    int du = (mask >> shiftU) & 3;
                    int dv = (mask >> shiftV) & 3;

                    if (du < P && dv < P) {
                        int nmask = mask + addMask;
                        if (dp[mask] + w < dp[nmask]) {
                            dp[nmask] = dp[mask] + w;
                        }
                    }
                }
            }
        }

        int maxPairs = 0;
        int minSum = Integer.MAX_VALUE;

        for (int mask = 0; mask <= maxMask; mask++) {
            if (dp[mask] != Integer.MAX_VALUE) {
                int pairs = 0;
                int temp = mask;
                while (temp > 0) {
                    pairs += (temp & 3);
                    temp >>= 2;
                }
                pairs /= 2;

                if (pairs > maxPairs) {
                    maxPairs = pairs;
                    minSum = dp[mask];
                } else if (pairs == maxPairs) {
                    if (dp[mask] < minSum) {
                        minSum = dp[mask];
                    }
                }
            }
        }

        if (minSum == Integer.MAX_VALUE) {
            minSum = 0;
        }

        System.out.println(maxPairs + " " + minSum);
    }
}