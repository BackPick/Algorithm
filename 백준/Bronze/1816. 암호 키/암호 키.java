import java.util.Scanner;

public class Main {
    static final long LIMIT = 1_000_000L;
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLong();
        }

        sieve((int)LIMIT);

        for (long num : numbers) {
            if (isValidKey(num)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void sieve(int max) {
        isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static boolean isValidKey(long n) {
        for (int i = 2; i <= LIMIT; i++) {
            if (isPrime[i] && n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
