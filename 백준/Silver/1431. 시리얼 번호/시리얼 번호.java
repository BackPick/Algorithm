import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int sumDigits(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') sum += c - '0';
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().trim();
        Arrays.sort(arr, Comparator
            .comparingInt(String::length)
            .thenComparingInt(s -> sumDigits(s))
            .thenComparing(Comparator.naturalOrder()));
        for (String s : arr) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }
}
