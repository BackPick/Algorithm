import java.util.*;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[6][6];

        for (int i = 0; i < 36; i++) {
            String s = sc.next();
            int x = s.charAt(0) - 'A';
            int y = s.charAt(1) - '1';
            path.add(new int[]{x, y});
        }

        for (int i = 0; i < 36; i++) {
            int[] cur = path.get(i);
            if (visited[cur[0]][cur[1]]) {
                System.out.println("Invalid");
                return;
            }
            visited[cur[0]][cur[1]] = true;

            if (i > 0) {
                int[] prev = path.get(i - 1);
                if (!isKnightMove(prev[0], prev[1], cur[0], cur[1])) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        // 마지막 → 첫 번째 이동 체크
        int[] first = path.get(0);
        int[] last = path.get(35);
        if (!isKnightMove(last[0], last[1], first[0], first[1])) {
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
    }

    public static boolean isKnightMove(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < 8; i++) {
            if (x1 + dx[i] == x2 && y1 + dy[i] == y2) return true;
        }
        return false;
    }
}
