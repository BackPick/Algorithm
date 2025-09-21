import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        int[] truth = new int[truthCount];
        for (int i = 0; i < truthCount; i++) truth[i] = Integer.parseInt(st.nextToken());

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) arr[j] = Integer.parseInt(st.nextToken());
            parties.add(arr);
            for (int j = 1; j < size; j++) union(arr[0], arr[j]);
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int t : truth) truthRoots.add(find(t));

        int answer = 0;
        for (int[] party : parties) {
            boolean canLie = true;
            for (int p : party) {
                if (truthRoots.contains(find(p))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
