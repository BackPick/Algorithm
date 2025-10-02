import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int L, K, C;
    static int[] pos;
    static boolean feasible(int X) {
        int last = 0;
        int cuts = 0;
        for (int i = 0; i <= K; i++) {
            int p = pos[i];
            if (p - last > X) {
                if (i == 0) return false;
                if (p - pos[i - 1] > X) return false;
                last = pos[i - 1];
                cuts++;
            }
        }
        return cuts <= C;
    }

    static boolean feasibleWithFirst(int X, int firstIdx) {
        int last = pos[firstIdx];
        if (last > X) return false;
        int cuts = 1;
        for (int i = firstIdx + 1; i <= K; i++) {
            int p = pos[i];
            if (p - last > X) {
                if (p - pos[i - 1] > X) return false;
                last = pos[i - 1];
                cuts++;
                if (cuts > C) return false;
            }
        }
        return cuts <= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pos = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        int[] tmp = new int[K];
        for (int i = 0; i < K; i++) tmp[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(tmp);
        for (int i = 0; i < K; i++) pos[i] = tmp[i];
        pos[K] = L;
        int lo = 1, hi = L, ans = L;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(mid)) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        int firstPos = 0;
        boolean found = false;
        for (int j = 0; j < K; j++) {
            if (feasibleWithFirst(ans, j)) {
                firstPos = pos[j];
                found = true;
                break;
            }
        }
        if (!found) firstPos = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans + " " + firstPos + "\n");
        bw.flush();
    }
}
