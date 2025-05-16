import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(countPossibleLocations(x1, y1, r1, x2, y2, r2));
        }
    }

    static int countPossibleLocations(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance == 0) {
            if (r1 == r2) return -1; // 같은 원
            else return 0; // 중심 같지만 반지름 다름
        }

        if (distance > r1 + r2) return 0;  // 멀리 떨어져서 안 만남
        else if (distance < Math.abs(r1 - r2)) return 0;  // 한 원이 다른 원 안에 있음
        else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) return 1;  // 외접 또는 내접
        else return 2;  // 두 점에서 만남
    }
}
