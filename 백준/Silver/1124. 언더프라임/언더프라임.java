import java.util.*;

public class Main {
    static final int MAX = 100000;
    static boolean[] isPrime = new boolean[MAX + 1];
    static int[] factorCount = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        sieve();  // 소수 판별
        countFactors();  // 각 수의 소인수 개수 구하기

        int count = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[factorCount[i]]) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 에라토스테네스의 체로 소수 구하기
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // 각 수에 대해 소인수 분해로 소수의 개수 세기
    static void countFactors() {
        for (int i = 2; i <= MAX; i++) {
            int n = i;
            int count = 0;
            for (int j = 2; j * j <= n; j++) {
                while (n % j == 0) {
                    count++;
                    n /= j;
                }
            }
            if (n > 1) count++;  // 마지막 남은 소인수
            factorCount[i] = count;
        }
    }
}
