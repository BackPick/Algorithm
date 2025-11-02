import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {

    static List<List<Integer>> adj;
    static int[] groups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj = Stream.generate(ArrayList<Integer>::new)
                        .limit(v + 1)
                        .collect(Collectors.toList());

            groups = new int[v + 1];

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj.get(u).add(w);
                adj.get(w).add(u);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= v; i++) {
                if (groups[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            bw.write(isBipartite ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        groups[startNode] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            int currentGroup = groups[u];
            int nextGroup = (currentGroup == 1) ? 2 : 1;

            for (int v : adj.get(u)) {
                if (groups[v] == 0) {
                    groups[v] = nextGroup;
                    q.add(v);
                } else if (groups[v] == currentGroup) {
                    return false;
                }
            }
        }
        return true;
    }
}