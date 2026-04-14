import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] x, y;
    static long totalX, totalY;
    static double answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine().trim());

            x = new long[N];
            y = new long[N];

            totalX = 0;
            totalY = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Long.parseLong(st.nextToken());
                y[i] = Long.parseLong(st.nextToken());

                totalX += x[i];
                totalY += y[i];
            }

            answer = Double.MAX_VALUE;

            comb(0, 0, 0, 0);

            sb.append(String.format("%.12f\n", answer));
        }

        System.out.print(sb);
    }

    static void comb(int idx, int cnt, long sx, long sy) {
        if (cnt == N / 2) {
            long vx = 2 * sx - totalX;
            long vy = 2 * sy - totalY;

            double dist = Math.sqrt(vx * vx + vy * vy);
            answer = Math.min(answer, dist);
            return;
        }

        if (idx == N) return;

        // 가지치기
        if (cnt + (N - idx) < N / 2) return;

        // 선택
        comb(idx + 1, cnt + 1, sx + x[idx], sy + y[idx]);

        // 선택 안함
        comb(idx + 1, cnt, sx, sy);
    }
}