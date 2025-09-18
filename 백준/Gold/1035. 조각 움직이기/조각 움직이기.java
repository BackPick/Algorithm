import java.io.*;
import java.util.*;

public class Main {
    static int n = 5;
    static ArrayList<int[]> pieces = new ArrayList<>();
    static int pieceCount;
    static ArrayList<int[]> candidates = new ArrayList<>();

    static void generateCandidates(int k) {
        int[] comb = new int[k];
        dfs(0, 0, k, comb);
    }

    static void dfs(int start, int depth, int k, int[] comb) {
        if (depth == k) {
            if (isConnected(comb, k)) {
                int[] copy = Arrays.copyOf(comb, k);
                candidates.add(copy);
            }
            return;
        }
        for (int i = start; i < 25; i++) {
            comb[depth] = i;
            dfs(i + 1, depth + 1, k, comb);
        }
    }

    static boolean isConnected(int[] arr, int k) {
        boolean[] vis = new boolean[k];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            int r = arr[u] / n, c = arr[u] % n;
            for (int i = 0; i < k; i++) {
                if (!vis[i]) {
                    int rr = arr[i] / n, cc = arr[i] % n;
                    if (Math.abs(r - rr) + Math.abs(c - cc) == 1) {
                        vis[i] = true;
                        cnt++;
                        q.add(i);
                    }
                }
            }
        }
        return cnt == k;
    }

    static int computeCost(int[] target) {
        int k = pieceCount;
        int[][] cost = new int[k][k];
        for (int i = 0; i < k; i++) {
            int r1 = pieces.get(i)[0], c1 = pieces.get(i)[1];
            for (int j = 0; j < k; j++) {
                int r2 = target[j] / n, c2 = target[j] % n;
                cost[i][j] = Math.abs(r1 - r2) + Math.abs(c1 - c2);
            }
        }
        return permuteMin(cost, new boolean[k], 0, 0);
    }

    static int permuteMin(int[][] cost, boolean[] used, int i, int sum) {
        int k = cost.length;
        if (i == k) return sum;
        int best = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            if (!used[j]) {
                used[j] = true;
                best = Math.min(best, permuteMin(cost, used, i + 1, sum + cost[i][j]));
                used[j] = false;
            }
        }
        return best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '*') {
                    pieces.add(new int[]{i, j});
                }
            }
        }
        pieceCount = pieces.size();
        generateCandidates(pieceCount);
        int ans = Integer.MAX_VALUE;
        for (int[] cand : candidates) {
            ans = Math.min(ans, computeCost(cand));
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
