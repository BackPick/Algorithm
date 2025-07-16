import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double gx = sc.nextDouble();
        double gy = sc.nextDouble();
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();

        while (sc.hasNext()) {
            double hx = sc.nextDouble();
            double hy = sc.nextDouble();

            double gopherDist = Math.hypot(gx - hx, gy - hy);
            double dogDist = Math.hypot(dx - hx, dy - hy);

            if (gopherDist * 2 <= dogDist) {
                System.out.printf("The gopher can escape through the hole at (%.3f,%.3f).%n", hx, hy);
                return;
            }
        }

        System.out.println("The gopher cannot escape.");
    }
}
