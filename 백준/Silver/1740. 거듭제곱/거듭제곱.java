import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(); // N은 최대 500,000,000,000

        BigInteger result = BigInteger.ZERO;
        BigInteger base = BigInteger.ONE;

        while (N > 0) {
            if ((N & 1) == 1) { // 현재 비트가 1이면 해당 3^i를 더함
                result = result.add(base);
            }
            base = base.multiply(BigInteger.valueOf(3)); // 3의 거듭제곱 갱신
            N >>= 1; // 비트 우측으로 이동 (N /= 2)
        }

        System.out.println(result);
    }
}
