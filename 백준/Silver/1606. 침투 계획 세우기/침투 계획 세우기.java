import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        
        if (x == 0 && y == 0) {
            System.out.println(1);
            return;
        }
        
        long n = (Math.abs(x) + Math.abs(y) + Math.abs(x + y)) / 2;
        long base = 0;
        long extra = 0;
        
        if (x >= 0 && y >= 0) {
            base = 0;
            extra = y;
        } else if (x < 0 && y > 0) {
            base = 1;
            extra = -x;
        } else if (x < 0 && y <= 0) {
            base = 2;
            extra = -y;
        } else if (x >= 0 && y < 0) {
            base = 3;
            extra = x;
        }
        
        long number = 1 + 3 * n * (n - 1) + base * n + extra;
        System.out.println(number);
    }
}