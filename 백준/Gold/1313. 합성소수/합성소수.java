import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final int MAX = 10_000_000;
    static boolean[] isPrime;
    static List<Integer> ansList = new ArrayList<>();
    static void sieve() {
        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int r = (int)Math.sqrt(MAX);
        for (int i = 2; i <= r; i++) if (isPrime[i]) {
            for (int j = i * i; j <= MAX; j += i) isPrime[j] = false;
        }
    }
    static boolean validAllSubstrings(String s) {
        int L = s.length();
        for (int i = 0; i < L; i++) {
            for (int j = i + 1; j < L; j++) {
                int len = j - i + 1;
                if (len >= 2 && len < L) {
                    int v = Integer.parseInt(s.substring(i, j + 1));
                    if (v > MAX || !isPrime[v]) return false;
                }
            }
        }
        return true;
    }
    static void dfs(String s) {
        if (!validAllSubstrings(s)) return;
        int L = s.length();
        if (L >= 3) {
            int v = Integer.parseInt(s);
            if (v <= MAX && !isPrime[v]) ansList.add(v);
        }
        if (L == 7) return;
        for (char d = '0'; d <= '9'; d++) {
            if (s.length() == 0 && d == '0') continue;
            dfs(s + d);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sieve();
        for (char c = '1'; c <= '9'; c++) dfs(String.valueOf(c));
        Collections.sort(ansList);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int idx = Collections.binarySearch(ansList, N);
            if (idx >= 0) {
                bw.write(Integer.toString(ansList.get(idx)));
                bw.newLine();
            } else {
                int pos = -idx - 1;
                if (pos - 1 >= 0) bw.write(Integer.toString(ansList.get(pos - 1)));
                else bw.write("-1");
                bw.newLine();
            }
        }
        bw.flush();
    }
}
