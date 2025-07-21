import java.util.Scanner;

public class Main {
    static int[] L, J;
    static int N, maxJoy = 0;

    public static void dfs(int idx, int hp, int joy) {
        if (hp <= 0) return;
        maxJoy = Math.max(maxJoy, joy);
        if (idx == N) return;
        dfs(idx + 1, hp, joy);
        dfs(idx + 1, hp - L[idx], joy + J[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = new int[N];
        J = new int[N];
        for (int i = 0; i < N; i++) L[i] = sc.nextInt();
        for (int i = 0; i < N; i++) J[i] = sc.nextInt();
        dfs(0, 100, 0);
        System.out.println(maxJoy);
    }
}
