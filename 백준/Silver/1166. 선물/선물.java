import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        double L = sc.nextDouble();
        double W = sc.nextDouble();
        double H = sc.nextDouble();

        double left = 0;
        double right = Math.min(Math.min(L, W), H);
        double mid = 0;

        for (int i = 0; i < 100; i++) {
            mid = (left + right) / 2;
            long count = (long)(L / mid) * (long)(W / mid) * (long)(H / mid);
            if (count >= N) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}
