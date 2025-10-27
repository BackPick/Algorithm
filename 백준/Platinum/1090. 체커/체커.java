import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] xs = new int[N];
        int[] ys = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }
        int[] uniqX = Arrays.stream(xs).distinct().toArray();
        int[] uniqY = Arrays.stream(ys).distinct().toArray();
        long INF = Long.MAX_VALUE / 4;
        long[] ans = new long[N+1];
        Arrays.fill(ans, INF);
        ans[0] = 0;
        for (int tx : uniqX) {
            for (int ty : uniqY) {
                long[] d = new long[N];
                for (int i = 0; i < N; i++) d[i] = Math.abs(xs[i] - tx) + Math.abs(ys[i] - ty);
                Arrays.sort(d);
                long sum = 0;
                for (int k = 1; k <= N; k++) {
                    sum += d[k-1];
                    if (sum < ans[k]) ans[k] = sum;
                }
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int k = 1; k <= N; k++) sj.add(String.valueOf(ans[k]));
        bw.write(sj.toString());
        bw.newLine();
        bw.flush();
    }
}
