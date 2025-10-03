import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        long overlap = Math.min(f, W - f);
        long d = x2 - x1;
        long left = Math.max(0L, Math.min(overlap, x2) - Math.min(overlap, x1));
        long paintedX = d + left;
        long paintedY = (y2 - y1) * (long)(c + 1);
        long painted = paintedX * paintedY;
        long total = W * H;
        long unpainted = total - painted;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(unpainted));
        bw.newLine();
        bw.flush();
    }
}
