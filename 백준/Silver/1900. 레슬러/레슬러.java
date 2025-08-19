import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int id, p, r;
        Player(int id, int p, int r) { this.id = id; this.p = p; this.r = r; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Player[] players = new Player[N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            players[i] = new Player(i + 1, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(players, (a, b) -> {
            long left = (long)a.p + (long)a.r * b.p;
            long right = (long)b.p + (long)b.r * a.p;
            return Long.compare(right, left); // 경기력 큰 쪽이 앞으로
        });

        StringBuilder sb = new StringBuilder();
        for (Player p : players) sb.append(p.id).append("\n");
        System.out.print(sb);
    }
}
