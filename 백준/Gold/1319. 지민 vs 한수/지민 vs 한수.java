import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] x = new int[N];
        int[] y = new int[N];
        long[] val = new long[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            val[i] = Long.parseLong(st.nextToken());
            total += val[i];
        }
        long best = total;
        if (N <= 1) {
            bw.write(String.valueOf(best));
            bw.newLine();
            bw.flush();
            return;
        }
        long[] proj = new long[N];
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dx = x[j] - x[i];
                int dy = y[j] - y[i];
                int[][] normals = new int[][]{{dx, dy}, {-dy, dx}};
                for (int[] normal : normals) {
                    int nx = normal[0], ny = normal[1];
                    for (int k = 0; k < N; k++) proj[k] = (long)x[k] * nx + (long)y[k] * ny;
                    Arrays.sort(idx, Comparator.comparingLong(a -> proj[a]));
                    long left = 0;
                    long curProj = proj[idx[0]];
                    long curSum = val[idx[0]];
                    for (int t = 1; t < N; t++) {
                        int id = idx[t];
                        if (proj[id] == curProj) curSum += val[id];
                        else {
                            left += curSum;
                            long right = total - left;
                            long diff = left > right ? left - right : right - left;
                            if (diff < best) best = diff;
                            if (best == 0) break outer;
                            curProj = proj[id];
                            curSum = val[id];
                        }
                    }
                    left += curSum;
                    long right = total - left;
                    long diff = left > right ? left - right : right - left;
                    if (diff < best) best = diff;
                    if (best == 0) break outer;
                }
            }
        }
        bw.write(String.valueOf(best));
        bw.newLine();
        bw.flush();
    }
}
