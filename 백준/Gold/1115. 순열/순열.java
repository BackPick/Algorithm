import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] P = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[] vis = new boolean[N];
        int cycles = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                cycles++;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = P[cur];
                }
            }
        }
        int ans = (cycles == 1) ? 0 : cycles;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
    }
}
