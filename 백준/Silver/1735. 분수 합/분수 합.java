import java.util.Scanner;

public class Main {

    // 최대공약수 구하는 함수 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 분수
        int a = scanner.nextInt(); // 분자
        int b = scanner.nextInt(); // 분모

        // 두 번째 분수
        int c = scanner.nextInt(); // 분자
        int d = scanner.nextInt(); // 분모

        // 분수 합치기
        int numerator = a * d + c * b;     // 새로운 분자
        int denominator = b * d;           // 새로운 분모

        // 기약분수로 만들기
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + " " + denominator);
    }
}
