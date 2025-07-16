import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();

        A %= B;

        for (int i = 1; i < N; i++) {
            A = (A * 10) % B;
        }

        A = (A * 10) / B;
        System.out.println(A);
    }
}
