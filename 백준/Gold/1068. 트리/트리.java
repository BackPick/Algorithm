import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int deleteNode;
    static List<Integer>[] children;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] parent = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        deleteNode = Integer.parseInt(br.readLine().trim());
        children = IntStream.range(0, N).mapToObj(i -> new ArrayList<Integer>()).toArray(List[]::new);
        int root = -1;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) root = i;
            else children[parent[i]].add(i);
        }
        if (deleteNode == root) {
            bw.write("0");
            bw.flush();
            return;
        }
        int ans = dfs(root);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    static int dfs(int u) {
        int cnt = 0;
        for (int v : children[u]) if (v != deleteNode) cnt++;
        if (cnt == 0) return 1;
        int sum = 0;
        for (int v : children[u]) if (v != deleteNode) sum += dfs(v);
        return sum;
    }
}
