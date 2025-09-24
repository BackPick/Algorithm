import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N;
    static int[] guilt;
    static int[][] R;
    static int mafia;
    static boolean[] alive;
    static int answer = 0;

    static void dfs(int nights, int aliveCount) {
        if (!alive[mafia]) {
            answer = Math.max(answer, nights);
            return;
        }
        if (aliveCount == 1) {
            answer = Math.max(answer, nights);
            return;
        }
        if (aliveCount % 2 == 0) {
            for (int i = 0; i < N; i++) {
                if (!alive[i] || i == mafia) continue;
                alive[i] = false;
                for (int j = 0; j < N; j++) if (alive[j]) guilt[j] += R[i][j];
                dfs(nights + 1, aliveCount - 1);
                for (int j = 0; j < N; j++) if (alive[j]) guilt[j] -= R[i][j];
                alive[i] = true;
            }
        } else {
            int kill = -1;
            for (int i = 0; i < N; i++) {
                if (!alive[i]) continue;
                if (kill == -1) kill = i;
                else if (guilt[i] > guilt[kill]) kill = i;
                else if (guilt[i] == guilt[kill] && i < kill) kill = i;
            }
            if (kill == mafia) {
                answer = Math.max(answer, nights);
                return;
            } else {
                alive[kill] = false;
                dfs(nights, aliveCount - 1);
                alive[kill] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        guilt = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        R = new int[N][N];
        for (int i = 0; i < N; i++) {
            R[i] = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        mafia = Integer.parseInt(br.readLine().trim());
        alive = new boolean[N];
        Arrays.fill(alive, true);
        dfs(0, N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }
}
