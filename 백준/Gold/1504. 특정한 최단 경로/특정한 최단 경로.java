import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;
    static class Edge { int to; int w; Edge(int t, int ww){to=t;w=ww;} }
    static long[] dijkstra(int src, List<Edge>[] g, int n) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, src});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int)cur[1];
            if (d > dist[u]) continue;
            for (Edge e : g[u]) {
                int v = e.to;
                long nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[]{nd, v});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Edge>[] g = Stream.generate(ArrayList<Edge>::new).limit(N+1).toArray(List[]::new);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long[] d1 = dijkstra(1, g, N);
        long[] dv1 = dijkstra(v1, g, N);
        long[] dv2 = dijkstra(v2, g, N);
        long path1 = (d1[v1] >= INF || dv1[v2] >= INF || dv2[N] >= INF) ? INF : d1[v1] + dv1[v2] + dv2[N];
        long path2 = (d1[v2] >= INF || dv2[v1] >= INF || dv1[N] >= INF) ? INF : d1[v2] + dv2[v1] + dv1[N];
        long ans = Math.min(path1, path2);
        if (ans >= INF) bw.write("-1\n"); else bw.write(String.valueOf(ans) + "\n");
        bw.flush();
    }
}
