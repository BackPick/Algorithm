import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(br.readLine());
            counts[price]++;
            maxSum += price;
        }

        if (maxSum == 0) {
            System.out.println(0);
            return;
        }

        boolean[] isPrime = new boolean[maxSum + 1];
        sieve(maxSum, isPrime);

        long[] dp = new long[maxSum + 1];
        dp[0] = 1;

        int countZero = counts[0];

        for (int v = 1; v <= 10000; v++) {
            if (counts[v] > 0) {
                int c = counts[v];
                long[] prevDp = dp.clone();
                for (int j = v; j <= maxSum; j++) {
                    dp[j] = dp[j - v] + prevDp[j];
                    if (j >= (c + 1) * v) {
                        dp[j] -= prevDp[j - (c + 1) * v];
                    }
                }
            }
        }

        if (countZero > 0) {
            for (int j = 1; j <= maxSum; j++) {
                if (dp[j] > 0) {
                    dp[j] *= (countZero + 1);
                }
            }
        }

        long answer = 0;
        for (int p = 2; p <= maxSum; p++) {
            if (isPrime[p]) {
                answer += dp[p];
            }
        }

        System.out.println(answer);
    }

    private static void sieve(int max, boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}