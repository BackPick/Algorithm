import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 제거

        char[][] room = new char[n][n];

        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextLine().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        // 가로 검사
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) horizontal++;
                    count = 0;
                }
            }
            if (count >= 2) horizontal++;
        }

        // 세로 검사
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) vertical++;
                    count = 0;
                }
            }
            if (count >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}
