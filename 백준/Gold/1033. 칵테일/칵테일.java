import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, p, q;
        Edge(int to, int p, int q) {
            this.to = to; this.p = p; this.q = q;
        }
    }

    static int N;
    static List<Edge>[] graph;
    static long[] num;
    static long[] den;
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;
        for (Edge e : graph[u]) {
            if (!visited[e.to]) {
                num[e.to] = num[u] * e.q;
                den[e.to] = den[u] * e.p;
                long g = gcd(num[e.to], den[e.to]);
                num[e.to] /= g;
                den[e.to] /= g;
                dfs(e.to);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine().trim());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, p, q));
            graph[b].add(new Edge(a, q, p));
        }

        num = new long[N];
        den = new long[N];
        visited = new boolean[N];
        num[0] = 1; den[0] = 1;
        dfs(0);

        long lcm = 1;
        for (int i = 0; i < N; i++) {
            lcm = lcm / gcd(lcm, den[i]) * den[i];
        }

        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = num[i] * (lcm / den[i]);
        }

        long g = res[0];
        for (int i = 1; i < N; i++) g = gcd(g, res[i]);
        for (int i = 0; i < N; i++) res[i] /= g;

        for (int i = 0; i < N; i++) {
            bw.write(res[i] + (i == N - 1 ? "\n" : " "));
        }
        bw.flush();
    }
}
