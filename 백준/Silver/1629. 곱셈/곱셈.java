import java.util.Scanner;

public class Main {
    static long modPow(long a, long b, long c) {
        if (b == 0) return 1;
        long half = modPow(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(modPow(a, b, c));
    }
}
