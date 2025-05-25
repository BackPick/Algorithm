import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 필요한 기타줄 개수
        int M = sc.nextInt(); // 브랜드 수

        int minPackage = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            int pack = sc.nextInt();
            int single = sc.nextInt();
            minPackage = Math.min(minPackage, pack);
            minSingle = Math.min(minSingle, single);
        }

        int cost1 = (N / 6) * minPackage + (N % 6) * minSingle;
        int cost2 = ((N + 5) / 6) * minPackage;
        int cost3 = N * minSingle;

        int result = Math.min(cost1, Math.min(cost2, cost3));
        System.out.println(result);
    }
}
