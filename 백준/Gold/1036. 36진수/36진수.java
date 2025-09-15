import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static int val(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        return c - 'A' + 10;
    }
    static char digit(int v) {
        if (v < 10) return (char)('0' + v);
        return (char)('A' + (v - 10));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().trim();
        int K = Integer.parseInt(br.readLine().trim());

        BigInteger[] gain = new BigInteger[36];
        for (int i = 0; i < 36; i++) gain[i] = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;

        for (String s : arr) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int v = val(s.charAt(len - 1 - i));
                BigInteger pow = BigInteger.valueOf(36).pow(i);
                sum = sum.add(pow.multiply(BigInteger.valueOf(v)));
                gain[v] = gain[v].add(pow.multiply(BigInteger.valueOf(35 - v)));
            }
        }

        Arrays.sort(gain, (a, b) -> b.compareTo(a));
        for (int i = 0; i < K && i < 36; i++) sum = sum.add(gain[i]);

        String ans = sum.toString(36).toUpperCase();
        System.out.println(ans);
    }
}
