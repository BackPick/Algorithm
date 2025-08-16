import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        if (N == 1) { System.out.println(1); return; }
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) if (isPrime[i]) 
            for (int j = i * i; j <= N; j += i) isPrime[j] = false;
        long result = 1;
        for (int i = 2; i <= N; i++) if (isPrime[i]) {
            long factor = i;
            while (factor * i <= N) factor *= i;
            result = (result * factor) % MOD;
        }
        System.out.println(result);
    }
}
