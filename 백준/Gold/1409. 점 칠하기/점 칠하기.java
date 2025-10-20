import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        boolean[] present = new boolean[360];
        for (int i = 0; i < N; i++) present[Integer.parseInt(br.readLine().trim())] = true;
        int best = 0;
        if (N <= 1) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        for (int r = 1; r < 360; r++) {
            boolean[] vis = new boolean[360];
            int totalColored = 0;
            for (int a = 0; a < 360; a++) {
                if (!present[a] || vis[a]) continue;
                int cnt = 0;
                ArrayDeque<Integer> dq = new ArrayDeque<>();
                dq.add(a);
                vis[a] = true;
                while (!dq.isEmpty()) {
                    int u = dq.poll();
                    cnt++;
                    int v1 = (u + r) % 360;
                    int v2 = (u - r + 360) % 360;
                    if (present[v1] && !vis[v1]) { vis[v1] = true; dq.add(v1); }
                    if (present[v2] && !vis[v2]) { vis[v2] = true; dq.add(v2); }
                }
                totalColored += (cnt / 2) * 2;
            }
            if (totalColored > best) best = totalColored;
            if (best == N) break;
        }
        bw.write(String.valueOf(best));
        bw.newLine();
        bw.flush();
    }
}
