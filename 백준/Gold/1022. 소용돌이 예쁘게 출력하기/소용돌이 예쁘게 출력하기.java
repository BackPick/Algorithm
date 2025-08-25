import java.io.*;
import java.util.*;

public class Main {
    static long valueAt(int r, int c) {
        int m = Math.max(Math.abs(r), Math.abs(c));
        long e = (long)(2*m+1)*(2*m+1);
        if (r == m) return e - (m - c);
        e -= 2*m;
        if (c == -m) return e - (m - r);
        e -= 2*m;
        if (r == -m) return e - (c + m);
        e -= 2*m;
        return e - (r + m);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int rows = r2 - r1 + 1, cols = c2 - c1 + 1;
        long[][] arr = new long[rows][cols];
        long maxv = 0;
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++) {
                arr[i][j] = valueAt(r1+i, c1+j);
                maxv = Math.max(maxv, arr[i][j]);
            }
        int width = Long.toString(maxv).length();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                sb.append(String.format("%" + width + "d", arr[i][j]));
                if (j < cols-1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
