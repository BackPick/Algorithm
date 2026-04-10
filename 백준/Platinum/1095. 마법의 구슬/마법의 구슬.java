import java.io.*;
import java.util.*;

public class Main {

    static long S, F, M;
    static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Long.parseLong(st.nextToken());
        F = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        N = S + F;

        for (long i = M; i >= 1; i--) {
            if (canDivide(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    static boolean canDivide(long x) {
        Map<Long, Integer> factors = factorize(x);

        for (Map.Entry<Long, Integer> entry : factors.entrySet()) {
            long p = entry.getKey();
            int need = entry.getValue();

            long cnt = count(N, p) - count(S, p) - count(F, p);

            if (cnt < need) return false;
        }
        return true;
    }

    static Map<Long, Integer> factorize(long x) {
        Map<Long, Integer> map = new HashMap<>();

        for (long i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }

        if (x > 1) map.put(x, map.getOrDefault(x, 0) + 1);

        return map;
    }

    static long count(long n, long p) {
        long cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }
}