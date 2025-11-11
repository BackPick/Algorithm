import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, P, K;
    static ArrayList<Edge>[] adj; 

    static class Node implements Comparable<Node> {
        int id;
        int kCount; 

        Node(int id, int kCount) {
            this.id = id;
            this.kCount = kCount;
        }

        @Override
        public int compareTo(Node o) {
            return this.kCount - o.kCount; 
        }
    }

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static boolean check(int maxCost) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;
            int kCount = current.kCount;

            if (kCount > dist[u]) {
                continue;
            }

            for (Edge edge : adj[u]) {
                int v = edge.to;
                int originalCost = edge.cost;

                int newWeight = (originalCost > maxCost) ? 1 : 0;
                int newKCount = kCount + newWeight;

                if (newKCount < dist[v]) {
                    dist[v] = newKCount;
                    pq.add(new Node(v, newKCount));
                }
            }
        }

        return dist[N] <= K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, cost));
            adj[to].add(new Edge(from, cost));
        }

        int lo = 0; 
        int hi = 1_000_000; 
        int ans = -1; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}