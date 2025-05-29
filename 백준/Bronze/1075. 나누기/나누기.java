import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int F = scanner.nextInt();

        int base = N / 100 * 100;

        for (int i = 0; i < 100; i++) {
            int candidate = base + i;
            if (candidate % F == 0) {
                System.out.printf("%02d\n", i);
                break;
            }
        }
    }
}
