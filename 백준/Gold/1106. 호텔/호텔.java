import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 필요한 고객 수
        int N = sc.nextInt(); // 도시 수

        int[] cost = new int[N];
        int[] customer = new int[N];

        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            customer[i] = sc.nextInt();
        }

        int maxCost = C * 100;
        int[] dp = new int[maxCost + 1];

        for (int i = 0; i <= maxCost; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= cost[j]) {
                    dp[i] = Math.max(dp[i], dp[i - cost[j]] + customer[j]);
                }
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= C) {
                System.out.println(i);
                break;
            }
        }
    }
}
