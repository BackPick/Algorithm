import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int count = 0;
        while (X > 0) {
            if (X % 2 == 1) count++;
            X /= 2;
        }
        System.out.println(count);
    }
}
