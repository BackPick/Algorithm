import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] maxPrime = new int[N + 1]; // 각 수의 최대 소인수 저장
        for (int i = 2; i <= N; i++) {
            if (maxPrime[i] == 0) { // i는 소수
                for (int j = i; j <= N; j += i) {
                    maxPrime[j] = i; // i는 j의 소인수 중 하나, 반복문 구조상 가장 큰 소인수로 덮어씀
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPrime[i] <= K) { // maxPrime[1] = 0 이므로 항상 포함됨
                count++;
            }
        }

        System.out.println(count);
    }
}
