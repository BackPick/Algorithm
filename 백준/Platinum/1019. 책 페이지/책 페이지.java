import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine().trim());
        long[] cnt = new long[10];
        long base = 1;
        while (base <= N) {
            long high = N / (base * 10);
            long cur = (N / base) % 10;
            long low = N % base;
            if (high > 0) {
                if (cur == 0) cnt[0] += (high - 1) * base + (low + 1);
                else cnt[0] += (high - 1) * base + base;
            }
            for (int d = 1; d <= 9; d++) {
                if (cur > d) cnt[d] += (high + 1) * base;
                else if (cur == d) cnt[d] += high * base + (low + 1);
                else cnt[d] += high * base;
            }
            base *= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (i > 0) bw.write(" ");
            bw.write(Long.toString(cnt[i]));
        }
        bw.newLine();
        bw.flush();
    }
}
