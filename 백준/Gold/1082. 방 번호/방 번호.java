import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] cost = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine().trim());

        int minDigit = 0;
        for (int i = 0; i < N; i++) {
            if (cost[i] < cost[minDigit] || (cost[i] == cost[minDigit] && i > minDigit)) minDigit = i;
        }

        int len = M / cost[minDigit];
        if (len == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        while (len > 0) {
            int[] res = new int[len];
            Arrays.fill(res, minDigit);
            int rem = M - len * cost[minDigit];
            boolean fail = false;
            for (int i = 0; i < len; i++) {
                boolean placed = false;
                for (int d = N - 1; d >= 0; d--) {
                    if (i == 0 && len > 1 && d == 0) continue;
                    if (rem + cost[minDigit] >= cost[d]) {
                        res[i] = d;
                        rem -= (cost[d] - cost[minDigit]);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    if (i == 0) fail = true;
                }
            }
            if (!fail) {
                StringBuilder sb = new StringBuilder();
                for (int x : res) sb.append(x);
                bw.write(sb.toString() + "\n");
                bw.flush();
                return;
            }
            len--;
        }

        bw.write("0\n");
        bw.flush();
    }
}
