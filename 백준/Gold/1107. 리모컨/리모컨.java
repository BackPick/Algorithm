import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            IntStream.range(0, M).forEach(i -> broken[Integer.parseInt(st.nextToken())] = true);
        }
        boolean[] ok = new boolean[10];
        for (int d = 0; d < 10; d++) ok[d] = !broken[d];
        int ans = Math.abs(N - 100);
        for (int ch = 0; ch <= 1000000; ch++) {
            int cur = ch;
            int len = 0;
            if (cur == 0) {
                if (!ok[0]) continue;
                len = 1;
            } else {
                boolean possible = true;
                while (cur > 0) {
                    int digit = cur % 10;
                    if (!ok[digit]) { possible = false; break; }
                    cur /= 10;
                    len++;
                }
                if (!possible) continue;
            }
            int presses = len + Math.abs(ch - N);
            if (presses < ans) ans = presses;
        }
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
    }
}
