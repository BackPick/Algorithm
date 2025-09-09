import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static boolean[] sieve(int n) {
        boolean[] p = new boolean[n+1];
        Arrays.fill(p, true);
        if (n >= 0) p[0] = false;
        if (n >= 1) p[1] = false;
        for (int i = 2; i * i <= n; i++) if (p[i]) for (int j = i*i; j <= n; j += i) p[j] = false;
        return p;
    }
    static boolean dfs(int u, List<int[]> adj, boolean[] vis, int[] matchR) {
        for (int v : adj.get(u)) {
            if (vis[v]) continue;
            vis[v] = true;
            if (matchR[v] == -1 || dfs(matchR[v], adj, vis, matchR)) {
                matchR[v] = u;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxVal = Arrays.stream(arr).max().orElse(0);
        boolean[] isPrime = sieve(maxVal * 2 + 1);
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < N; i++) if ((arr[i] & 1) == 0) evens.add(i); else odds.add(i);
        if (evens.size() != odds.size()) {
            bw.write("-1");
            bw.flush();
            return;
        }
        int firstParity = arr[0] & 1;
        List<Integer> same = firstParity == 0 ? evens : odds;
        List<Integer> other = firstParity == 0 ? odds : evens;
        List<Integer> results = new ArrayList<>();
        for (int candIdx : other) {
            if (!isPrime[arr[0] + arr[candIdx]]) continue;
            List<Integer> left = new ArrayList<>();
            for (int x : same) if (x != 0) left.add(x);
            List<Integer> right = new ArrayList<>();
            for (int x : other) if (x != candIdx) right.add(x);
            int L = left.size(), R = right.size();
            Map<Integer,Integer> ridx = new HashMap<>();
            for (int i = 0; i < R; i++) ridx.put(right.get(i), i);
            List<int[]> adj = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int v : right) if (isPrime[arr[left.get(i)] + arr[v]]) tmp.add(ridx.get(v));
                int[] a = tmp.stream().mapToInt(Integer::intValue).toArray();
                adj.add(a);
            }
            int[] matchR = new int[R];
            Arrays.fill(matchR, -1);
            int match = 0;
            boolean ok = true;
            for (int u = 0; u < L; u++) {
                boolean[] vis = new boolean[R];
                if (dfs(u, adj, vis, matchR)) match++;
                else { ok = false; break; }
            }
            if (ok && match == L) results.add(arr[candIdx]);
        }
        if (results.isEmpty()) {
            bw.write("-1");
        } else {
            Collections.sort(results);
            for (int i = 0; i < results.size(); i++) {
                if (i > 0) bw.write(" ");
                bw.write(String.valueOf(results.get(i)));
            }
        }
        bw.flush();
    }
}
