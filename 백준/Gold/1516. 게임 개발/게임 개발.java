import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] time = new int[N+1];
        int[] indeg = new int[N+1];
        List<Integer>[] adj = Stream.generate(ArrayList<Integer>::new).limit(N+1).toArray(List[]::new);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                adj[x].add(i);
                indeg[i]++;
            }
        }
        int[] dist = new int[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                dist[i] = time[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                dist[v] = Math.max(dist[v], dist[u] + time[v]);
                if (--indeg[v] == 0) q.add(v);
            }
        }
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(dist[i]));
            bw.newLine();
        }
        bw.flush();
    }
}
