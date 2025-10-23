import java.io.*;
import java.util.*;

public class Main {
    static int K, M;
    static int[] pos;
    static boolean feasible(int d) {
        int cnt = 1;
        int last = pos[0];
        for (int i = 1; i < K; i++) {
            if (pos[i] - last >= d) { cnt++; last = pos[i]; if (cnt >= M) return true; }
        }
        return cnt >= M;
    }
    static boolean canPlaceFrom(int startIdx, int lastPosValue, int need, int d) {
        int left = need;
        int last = lastPosValue;
        for (int j = startIdx; j < K && left > 0; j++) {
            if (pos[j] - last >= d) { left--; last = pos[j]; }
        }
        return left == 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) pos[i] = Integer.parseInt(st.nextToken());
        int lo = 0, hi = N, best = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (feasible(mid)) { best = mid; lo = mid + 1; }
            else hi = mid - 1;
        }
        StringBuilder sb = new StringBuilder();
        int remain = M;
        int lastPosValue = Integer.MIN_VALUE / 4;
        for (int i = 0; i < K; i++) {
            if (remain == 0) { sb.append('0'); continue; }
            // try put 1 at i: we set last to pos[i] and need remain-1 from i+1
            boolean putOne = false;
            int needIfOne = remain - 1;
            if (pos[i] - lastPosValue >= best) {
                if (needIfOne == 0) putOne = true;
                else {
                    if (canPlaceFrom(i + 1, pos[i], needIfOne, best)) putOne = true;
                }
            }
            if (putOne) {
                sb.append('1');
                lastPosValue = pos[i];
                remain--;
            } else {
                // ensure still possible to place remain without choosing i
                if (!canPlaceFrom(i + 1, lastPosValue, remain, best)) {
                    // if impossible, must put 1 (this case shouldn't occur when best is feasible, but guard)
                    sb.append('1');
                    lastPosValue = pos[i];
                    remain--;
                } else sb.append('0');
            }
        }
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
    }
}
