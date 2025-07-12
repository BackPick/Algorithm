import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int node;
        int index;
        public Pair(int node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n+1];
        List<Integer>[] revGraph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            revGraph[a].add(b);
        }

        boolean[] visited = new boolean[n+1];
        Stack<Integer> finishStack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                Stack<Pair> stack = new Stack<>();
                stack.push(new Pair(i, 0));
                visited[i] = true;
                while (!stack.isEmpty()) {
                    Pair p = stack.peek();
                    int u = p.node;
                    int idx = p.index;
                    if (idx < graph[u].size()) {
                        int v = graph[u].get(idx);
                        p.index++;
                        if (!visited[v]) {
                            visited[v] = true;
                            stack.push(new Pair(v, 0));
                        }
                    } else {
                        stack.pop();
                        finishStack.push(u);
                    }
                }
            }
        }

        Arrays.fill(visited, false);
        int compCount = 0;
        int[] compId = new int[n+1];
        int[] compSize = new int[n];
        Arrays.fill(compId, -1);

        while (!finishStack.isEmpty()) {
            int node = finishStack.pop();
            if (!visited[node]) {
                List<Integer> compNodes = new ArrayList<>();
                Stack<Pair> stack = new Stack<>();
                stack.push(new Pair(node, 0));
                visited[node] = true;
                compNodes.add(node);
                while (!stack.isEmpty()) {
                    Pair p = stack.peek();
                    int u = p.node;
                    int idx = p.index;
                    if (idx < revGraph[u].size()) {
                        int v = revGraph[u].get(idx);
                        p.index++;
                        if (!visited[v]) {
                            visited[v] = true;
                            compNodes.add(v);
                            stack.push(new Pair(v, 0));
                        }
                    } else {
                        stack.pop();
                    }
                }
                for (int u : compNodes) {
                    compId[u] = compCount;
                }
                compSize[compCount] = compNodes.size();
                compCount++;
            }
        }

        Set<Integer>[] dag = new HashSet[compCount];
        for (int i = 0; i < compCount; i++) {
            dag[i] = new HashSet<>();
        }
        for (int u = 1; u <= n; u++) {
            for (int v : graph[u]) {
                int compU = compId[u];
                int compV = compId[v];
                if (compU != compV) {
                    dag[compU].add(compV);
                }
            }
        }

        int[] indegree = new int[compCount];
        for (int i = 0; i < compCount; i++) {
            for (int neighbor : dag[i]) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < compCount; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            for (int v : dag[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        List<Integer> reverseOrder = new ArrayList<>(topoOrder);
        Collections.reverse(reverseOrder);

        BitSet[] reachable = new BitSet[compCount];
        for (int i = 0; i < compCount; i++) {
            reachable[i] = new BitSet(compCount);
            reachable[i].set(i);
        }

        for (int u : reverseOrder) {
            for (int v : dag[u]) {
                reachable[u].or(reachable[v]);
            }
        }

        int[] totalReachable = new int[compCount];
        for (int i = 0; i < compCount; i++) {
            for (int j = 0; j < compCount; j++) {
                if (reachable[i].get(j)) {
                    totalReachable[i] += compSize[j];
                }
            }
        }

        int maxTotal = 0;
        for (int i = 0; i < compCount; i++) {
            if (totalReachable[i] > maxTotal) {
                maxTotal = totalReachable[i];
            }
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (totalReachable[compId[i]] == maxTotal) {
                candidates.add(i);
            }
        }

        Collections.sort(candidates);
        StringBuilder sb = new StringBuilder();
        for (int node : candidates) {
            sb.append(node).append(' ');
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}