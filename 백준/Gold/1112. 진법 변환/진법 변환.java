import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (x == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        if (b > 0) {
            StringBuilder sb = new StringBuilder();
            long t = Math.abs(x);
            while (t > 0) {
                int r = (int)(t % b);
                sb.append((char)('0' + r));
                t /= b;
            }
            if (x < 0) sb.append('-');
            char[] arr = sb.reverse().toString().toCharArray();
            bw.write(new String(arr));
            bw.newLine();
            bw.flush();
            return;
        }
        int base = Math.abs(b);
        StringBuilder sb = new StringBuilder();
        long cur = x;
        while (cur != 0) {
            long r = cur % b;
            cur = cur / b;
            if (r < 0) { r += base; cur += 1; }
            sb.append((char)('0' + (int)r));
        }
        String srev = sb.toString();
        char[] out = srev.toCharArray();
        IntStream.range(0, out.length / 2).forEach(i -> {
            char tmp = out[i];
            out[i] = out[out.length - 1 - i];
            out[out.length - 1 - i] = tmp;
        });
        bw.write(new String(out));
        bw.newLine();
        bw.flush();
    }
}
