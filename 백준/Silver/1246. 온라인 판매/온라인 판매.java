import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 달걀 수
        int m = sc.nextInt(); // 고객 수

        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        int maxProfit = 0;
        int bestPrice = 0;

        for (int i = 0; i < m; i++) {
            int price = p[i];
            int buyers = m - i;
            int sellCount = Math.min(buyers, n);
            int profit = price * sellCount;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestPrice = price;
            }
        }

        System.out.println(bestPrice + " " + maxProfit);
    }
}
