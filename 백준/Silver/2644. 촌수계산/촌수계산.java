
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> graph;
    private static boolean[]           visited;
    private static int                 person1;
    private static int                 person2;
    private static int                 relCount = -1; // 촌수

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 사람의 수 n
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());
        // 부모 자식들 간의 관계의 개수 m
        int m = Integer.parseInt(br.readLine());

        // 1부터 사용 -> 각각 n+1
        graph   = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x)
                    .add(y);
            graph.get(y)
                    .add(x);
        }

        // DFS로 촌수 계산
        dfs(person1, 0);

        System.out.println(relCount);
    }

    private static void dfs(int current, int depth) {
        if (current == person2) {
            relCount = depth;
            return;
        }

        visited[current] = true;

        for (Integer neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
            }
        }
        
    }
}
