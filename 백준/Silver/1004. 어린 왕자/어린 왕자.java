import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int n = sc.nextInt(); // 행성계의 수

            int count = 0;

            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();

                boolean isStartInside = isInsideCircle(x1, y1, cx, cy, r);
                boolean isEndInside = isInsideCircle(x2, y2, cx, cy, r);

                // 둘 중 하나만 포함되면 진입/이탈 1회
                if (isStartInside != isEndInside) {
                    count++;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }

    // 점 (x, y)가 원 (cx, cy, r)의 내부에 있는지 판별
    private static boolean isInsideCircle(int x, int y, int cx, int cy, int r) {
        int dx = x - cx;
        int dy = y - cy;
        return dx * dx + dy * dy < r * r;
    }
}
