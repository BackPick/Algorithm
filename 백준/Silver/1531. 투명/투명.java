import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 종이 개수
        int M = sc.nextInt(); // M장 이하면 그림이 보임

        int[][] cover = new int[101][101]; // 그림의 덮인 정도 (1-based index)

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // 해당 종이의 영역을 +1씩 증가
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    cover[x][y]++;
                }
            }
        }

        // 덮인 종이가 M장 초과인 칸 세기
        int count = 0;
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                if (cover[x][y] > M) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
