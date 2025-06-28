import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int K = sc.nextInt();

        int base = S / K;
        int remain = S % K;
        long result = 1;

        for (int i = 0; i < K - remain; i++) {
            result *= base;
        }

        for (int i = 0; i < remain; i++) {
            result *= (base + 1);
        }

        System.out.println(result);
    }
}
