import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K;
    static int R1, R2, C1, C2;

    static boolean isBlack(int r, int c, int level) {
        if (level == 0) return false;
        int blockSize = (int) Math.pow(N, level - 1);
        int br = (r / blockSize) % N;
        int bc = (c / blockSize) % N;
        int start = (N - K) / 2;
        int end = start + K;
        if (br >= start && br < end && bc >= start && bc < end) return true;
        return isBlack(r, c, level - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int r = R1; r <= R2; r++) {
            for (int c = C1; c <= C2; c++) {
                sb.append(isBlack(r, c, s) ? '1' : '0');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
