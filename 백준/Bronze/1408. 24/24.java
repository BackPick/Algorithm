import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.next();
        String target = sc.next();

        int nowSeconds = toSeconds(now);
        int targetSeconds = toSeconds(target);

        int diff = (targetSeconds - nowSeconds + 86400) % 86400;

        System.out.println(toTime(diff));
    }

    public static int toSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    public static String toTime(int seconds) {
        int h = seconds / 3600;
        seconds %= 3600;
        int m = seconds / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
