import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static boolean check(int n, double[] arr) {
        for (double a : arr) {
            double low = a * n;
            double high = (a + 0.001) * n;
            int smin = (int)Math.ceil(low - 1e-9);
            int smax = (int)Math.floor(high - 1e-9);
            if (smax < smin) return false;
            if (smax < 0 || smin > 10*n) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) arr[i] = Double.parseDouble(br.readLine().trim());
        int ans = -1;
        for (int n = 1; n <= 1000000; n++) {
            if (check(n, arr)) { ans = n; break; }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
