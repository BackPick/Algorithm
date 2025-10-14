import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        long a = Math.min(X, Y);
        long b = Math.max(X, Y);
        long d = b - a;
        long ans;
        if (2 * W <= S) ans = (X + Y) * W;
        else if (W <= S) ans = a * S + d * W;
        else ans = a * S + (d / 2) * 2 * S + (d % 2) * W;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
