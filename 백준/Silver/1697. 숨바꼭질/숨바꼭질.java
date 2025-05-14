

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_N = 100000; // MAX_N을 100000으로 설정
    private static Queue<Integer> queue;
    private static boolean[] visited;
    private static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        queue = new LinkedList<>();
        visited = new boolean[MAX_N + 1];
        time = new int[MAX_N + 1];
        
        bfs(n, k);
    }

    private static void bfs(int n, int k) {
        queue.offer(n);
        visited[n] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            // 동생을 찾은 경우
            if (now == k) {
                System.out.println(time[now]);
                return;
            }
            
            // (x-1)
            if (now - 1 >= 0 && !visited[now - 1]) {
                visited[now - 1] = true;
                time[now - 1] = time[now] + 1;
                queue.offer(now - 1);
            }
            
            // (x+1)
            if (now + 1 <= MAX_N && !visited[now + 1]) { // MAX_N 체크 추가
                visited[now + 1] = true;
                time[now + 1] = time[now] + 1;
                queue.offer(now + 1);
            }
            
            // 2 * X
            if (now * 2 <= MAX_N && !visited[now * 2]) {
                visited[now * 2] = true;
                time[now * 2] = time[now] + 1;
                queue.offer(now * 2);
            }
        }
    }
}
