import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K == 0) { System.out.println(-1); return; }
        long ans = 0;
        while (Long.bitCount(N) > K) {
            long lsb = N & -N;
            ans += lsb;
            N += lsb;
        }
        System.out.println(ans);
    }
}
