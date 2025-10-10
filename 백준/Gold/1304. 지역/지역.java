import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, M;
    static List<Integer>[] g;
    static int[] index, low, comp;
    static boolean[] on;
    static Deque<Integer> stack = new ArrayDeque<>();
    static int idx = 1, compCnt = 0;
    static void dfs(int u){
        index[u]=low[u]=idx++;
        stack.push(u);
        on[u]=true;
        for(int v: g[u]){
            if(index[v]==0){
                dfs(v);
                low[u]=Math.min(low[u], low[v]);
            } else if(on[v]){
                low[u]=Math.min(low[u], index[v]);
            }
        }
        if(low[u]==index[u]){
            compCnt++;
            while(true){
                int w = stack.pop();
                on[w]=false;
                comp[w]=compCnt;
                if(w==u) break;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = Stream.generate(ArrayList<Integer>::new).limit(N+1).toArray(List[]::new);
        for (int i = 1; i < N; i++) g[i].add(i+1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            g[s].add(e);
        }
        index = new int[N+1];
        low = new int[N+1];
        comp = new int[N+1];
        on = new boolean[N+1];
        for(int i=1;i<=N;i++) if(index[i]==0) dfs(i);
        int C = compCnt;
        int[] minIdx = new int[C+1];
        int[] sz = new int[C+1];
        Arrays.fill(minIdx, Integer.MAX_VALUE);
        for(int i=1;i<=N;i++){
            int cid = comp[i];
            sz[cid]++;
            minIdx[cid] = Math.min(minIdx[cid], i);
        }
        Integer[] ids = IntStream.rangeClosed(1, C).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, Comparator.comparingInt(a -> minIdx[a]));
        int[] sizes = new int[C];
        for(int i=0;i<C;i++) sizes[i]=sz[ids[i]];
        int answer = 1;
        outer:
        for(int k = N; k >= 1; k--) {
            if(N % k != 0) continue;
            int gsize = N / k;
            int cur = 0;
            for(int s : sizes) {
                cur += s;
                if(cur == gsize) cur = 0;
                else if(cur > gsize) continue outer;
            }
            if(cur == 0) { answer = k; break; }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
