import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] P = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] S = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[N];
        List<List<Integer>> cycles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Integer> cyc = new ArrayList<>();
                int cur = i;
                while (!visited[cur]) {
                    visited[cur] = true;
                    cyc.add(cur);
                    cur = S[cur];
                }
                cycles.add(cyc);
            }
        }
        List<boolean[]> allowedList = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        for (List<Integer> cyc : cycles) {
            int L = cyc.size();
            lengths.add(L);
            boolean[] allowed = new boolean[L];
            Arrays.fill(allowed, true);
            for (int t = 0; t < L; t++) {
                int pos = cyc.get(t);
                boolean[] nodeAllowed = new boolean[L];
                for (int s = 0; s < L; s++) {
                    if (cyc.get(s) % 3 == P[pos]) {
                        int k = (s - t) % L;
                        if (k < 0) k += L;
                        nodeAllowed[k] = true;
                    }
                }
                for (int x = 0; x < L; x++) allowed[x] = allowed[x] && nodeAllowed[x];
            }
            boolean any = false;
            for (boolean b : allowed) if (b) { any = true; break; }
            if (!any) {
                bw.write("-1");
                bw.flush();
                return;
            }
            allowedList.add(allowed);
        }
        int bigL = 1;
        for (int L : lengths) bigL = lcm(bigL, L);
        boolean[] ok = new boolean[bigL];
        Arrays.fill(ok, true);
        for (int idx = 0; idx < allowedList.size(); idx++) {
            boolean[] allowed = allowedList.get(idx);
            int Li = lengths.get(idx);
            for (int x = 0; x < bigL; x++) if (!allowed[x % Li]) ok[x] = false;
        }
        int ans = -1;
        for (int x = 0; x < bigL; x++) if (ok[x]) { ans = x; break; }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
