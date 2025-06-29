import java.util.Scanner;

public class Main {
    static double[][] p = new double[8][8];
    static double[][] dp = new double[4][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                double win = sc.nextInt() / 100.0;
                p[i][j] = win;
                p[j][i] = 1.0 - win;
            }
        }

        for (int i = 0; i < 8; i++) dp[0][i] = 1.0;

        for (int round = 1; round <= 3; round++) {
            int groupSize = 1 << round;
            int halfGroup = groupSize / 2;

            for (int i = 0; i < 8; i++) {
                int groupStart = (i / groupSize) * groupSize;
                for (int j = groupStart; j < groupStart + groupSize; j++) {
                    if ((i / halfGroup) != (j / halfGroup)) {
                        dp[round][i] += dp[round - 1][i] * dp[round - 1][j] * p[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.printf("%.10f ", dp[3][i]);
        }
    }
}
