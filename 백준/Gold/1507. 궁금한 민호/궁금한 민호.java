import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        long[][] d = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) d[i][j] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < N; i++) if (d[i][i] != 0) { bw.write("-1\n"); bw.flush(); return; }
        boolean[][] unnecessary = new boolean[N][N];
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = i + 1; j < N; j++) {
                    if (j == k) continue;
                    long via = d[i][k] + d[k][j];
                    if (d[i][j] > via) { bw.write("-1\n"); bw.flush(); return; }
                    if (d[i][j] == via) { unnecessary[i][j] = true; unnecessary[j][i] = true; }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < N; i++) for (int j = i + 1; j < N; j++) if (!unnecessary[i][j]) sum += d[i][j];
        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
    }
}
