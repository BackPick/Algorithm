import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] mat = new String[N];
        for (int i = 0; i < N; i++) mat[i] = br.readLine().trim();

        int[] deg = new int[N];
        int edgeSum = 0;
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (mat[i].charAt(j) == 'Y') {
                    deg[i]++; deg[j]++;
                    edgeSum += 1;
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int E = edgeSum;

        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (deg[i] == 0) { // isolated vertex: impossible to make the graph connected
                System.out.println(-1);
                return;
            }
        }

        if (E < N - 1) {
            System.out.println(-1);
            return;
        }

        boolean[] vis = new boolean[N];
        int comps = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                comps++;
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(i); vis[i] = true;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj[u]) if (!vis[v]) { vis[v] = true; q.add(v); }
                }
            }
        }

        System.out.println(comps - 1);
    }
}
