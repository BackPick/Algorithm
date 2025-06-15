import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (map[i][j] == 'Y') {
                    visited[j] = true;
                } else {
                    for (int k = 0; k < n; k++) {
                        if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }

            for (boolean v : visited) {
                if (v) count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
