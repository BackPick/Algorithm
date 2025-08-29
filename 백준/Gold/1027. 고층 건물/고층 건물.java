import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] h = new long[N];
        for (int i = 0; i < N; i++) h[i] = sc.nextLong();

        int ans = IntStream.range(0, N).map(i -> {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                boolean visible = true;
                for (int k = Math.min(i, j) + 1; k < Math.max(i, j); k++) {
                    double y = (double)(h[j] - h[i]) * (k - i) / (j - i) + h[i];
                    if (h[k] >= y - 1e-9) {
                        visible = false;
                        break;
                    }
                }
                if (visible) cnt++;
            }
            return cnt;
        }).max().orElse(0);

        System.out.println(ans);
    }
}
