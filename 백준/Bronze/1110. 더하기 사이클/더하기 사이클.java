import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int original = n;
        int count = 0;

        do {
            int a = n / 10;
            int b = n % 10;
            int c = (a + b) % 10;
            n = b * 10 + c;
            count++;
        } while (n != original);

        System.out.println(count);
    }
}
