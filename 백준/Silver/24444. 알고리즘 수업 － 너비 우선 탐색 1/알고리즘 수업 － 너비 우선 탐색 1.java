import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[]     visitOrder;
    static boolean[] visited;
    static int       order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 N, 간선 M, 시작점 R
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visitOrder = new int[N + 1];
        visited    = new boolean[N + 1];

        bfs(R, graph);

        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i] == 0 ? 0 : visitOrder[i]);
        }
    }

    // BFS 메서드
    private static void bfs(int start, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start]    = true;
        visitOrder[start] = order++;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor]    = true;
                    visitOrder[neighbor] = order++;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
