import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[]           visited;
    private static int                 count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph   = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u)
                    .add(v);
            graph.get(v)
                    .add(u);
        }
        dfs(1);
        System.out.println(count - 1);

    }

    private static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        count++;
        visited[i] = true;
        for (Integer integer : graph.get(i)) {
            if (!visited[integer]) {
                dfs(integer);
            }
        }
    }
}