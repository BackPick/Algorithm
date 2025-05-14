
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int     n  = sc.nextInt();

        // 행렬 A
        for (int a = 1; a <= n; a++) {
            for (int i = 1; i <= a; i++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - a); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= a; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 행렬 B
        for (int b = 1; b <= n - 1; b++) {
            for (int i = n - 1; i >= b; i--) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * b; j++) {
                System.out.print(" ");
            }
            for (int k = n - 1; k >= b; k--) {
                System.out.print("*");
            }
            if (b != n - 1) {
                System.out.println();
            }
        }
        sc.close();
    }
}