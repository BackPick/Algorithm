import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(parts[j]);
        }
        int ans = Integer.MAX_VALUE;
        for (int joker = -1; joker < N; joker++) {
            boolean[] colorHasMono = new boolean[M];
            int emptyCount = 0;
            for (int i = 0; i < N; i++) {
                if (i == joker) continue;
                int nonzeroColors = 0;
                int lastColor = -1;
                int total = 0;
                for (int c = 0; c < M; c++) {
                    if (a[i][c] > 0) { nonzeroColors++; lastColor = c; total += a[i][c]; }
                }
                if (total == 0) emptyCount++;
                else if (nonzeroColors == 1) colorHasMono[lastColor] = true;
            }
            int monoColorCount = 0;
            for (int c = 0; c < M; c++) if (colorHasMono[c]) monoColorCount++;
            int keep = (joker == -1 ? 0 : 1) + emptyCount + monoColorCount;
            ans = Math.min(ans, N - keep);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
