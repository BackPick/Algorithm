import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] t = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = t[0], r = t[1], c = t[2];
        int ans = 0;
        for (int n = N; n > 0; n--) {
            int half = 1 << (n - 1);
            int q = (r >= half ? 2 : 0) + (c >= half ? 1 : 0);
            ans += q * half * half;
            if (r >= half) r -= half;
            if (c >= half) c -= half;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
