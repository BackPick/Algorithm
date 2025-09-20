import java.io.*;
import java.util.*;

public class Main {
    static class State {
        String val;
        int depth;
        State(String v, int d) { val = v; depth = d; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int len = N.length();

        if (len == 1 || (len == 2 && N.charAt(1) == '0' && K % 2 == 1)) {
            bw.write("-1\n");
            bw.flush();
            return;
        }

        Queue<State> q = new ArrayDeque<>();
        q.add(new State(N, 0));
        HashSet<String>[] visited = new HashSet[K + 1];
        for (int i = 0; i <= K; i++) visited[i] = new HashSet<>();
        visited[0].add(N);

        int ans = -1;
        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth == K) {
                ans = Math.max(ans, Integer.parseInt(cur.val));
                continue;
            }
            char[] arr = cur.val.toCharArray();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    swap(arr, i, j);
                    if (arr[0] != '0') {
                        String next = new String(arr);
                        if (!visited[cur.depth + 1].contains(next)) {
                            visited[cur.depth + 1].add(next);
                            q.add(new State(next, cur.depth + 1));
                        }
                    }
                    swap(arr, i, j);
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
