import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] D = new int[N+1], indeg = new int[N+1], dp = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1;i<=N;i++) D[i] = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] g = new ArrayList[N+1];
            for (int i=1;i<=N;i++) g[i] = new ArrayList<>();
            for (int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                g[x].add(y);
                indeg[y]++;
            }
            int W = Integer.parseInt(br.readLine().trim());
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i=1;i<=N;i++) {
                dp[i] = D[i];
                if (indeg[i]==0) q.add(i);
            }
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (dp[v] < dp[u] + D[v]) dp[v] = dp[u] + D[v];
                    if (--indeg[v]==0) q.add(v);
                }
            }
            out.append(dp[W]).append('\n');
        }
        System.out.print(out);
    }
}
