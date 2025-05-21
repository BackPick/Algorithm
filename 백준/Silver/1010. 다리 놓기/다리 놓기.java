import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    static BigInteger[] factorial = new BigInteger[31]; // 0~30

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        computeFactorials(); // 미리 팩토리얼 계산

        while (T-- > 0) {
            String[] parts = br.readLine().split(" ");
            int N = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);

            BigInteger result = combination(M, N);
            System.out.println(result);
        }
    }

    static void computeFactorials() {
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i <= 30; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    static BigInteger combination(int n, int r) {
        return factorial[n].divide(factorial[r].multiply(factorial[n - r]));
    }
}
