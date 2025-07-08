import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();
        int[] trees = new int[N];
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            if (trees[i] > maxLen) maxLen = trees[i];
        }

        long maxProfit = 0;

        for (int targetLen = 1; targetLen <= maxLen; targetLen++) {
            long totalProfit = 0;

            for (int i = 0; i < N; i++) {
                int tree = trees[i];
                int pieces = tree / targetLen;
                if (pieces == 0) continue;

                int cuts = tree % targetLen == 0 ? pieces - 1 : pieces;
                long cost = cuts * (long) C;
                long profit = (long) pieces * targetLen * W - cost;

                if (profit > 0) totalProfit += profit;
            }

            if (totalProfit > maxProfit) maxProfit = totalProfit;
        }

        System.out.println(maxProfit);
    }
}
