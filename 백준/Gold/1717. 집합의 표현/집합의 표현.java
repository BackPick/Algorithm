import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int     N  = sc.nextInt();
        int     M  = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            // 초기화
            parent[i] = i;
        }

        // 질의 계산
        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a        = sc.nextInt();
            int b        = sc.nextInt();
            // 합집합인가
            if (question == 0) {
                union(a, b);
            }
            //
            else {
                boolean result = checkSame(a, b);
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        else {
            return find(parent[a]);
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        return false;
    }
}