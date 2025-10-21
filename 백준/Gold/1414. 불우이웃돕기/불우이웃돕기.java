import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static class DSU {
        int[] p;
        DSU(int n){ p = new int[n+1]; for(int i=1;i<=n;i++) p[i]=i; }
        int find(int x){ return p[x]==x?x:(p[x]=find(p[x])); }
        boolean union(int a,int b){ a=find(a); b=find(b); if(a==b) return false; p[b]=a; return true; }
    }
    static int weight(char c){
        if (c == '0') return 0;
        if ('a' <= c && c <= 'z') return c - 'a' + 1;
        return c - 'A' + 27;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        long total = 0;
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                char ch = line.charAt(j-1);
                int w = weight(ch);
                total += w;
                if (i != j && w > 0) edges.add(new int[]{w, i, j});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[0]));
        DSU dsu = new DSU(N);
        long mst = 0;
        int used = 0;
        for (int[] e : edges) {
            if (dsu.union(e[1], e[2])) {
                mst += e[0];
                if (++used == N-1) break;
            }
        }
        if (used != N-1) bw.write("-1\n"); else bw.write(String.valueOf(total - mst) + "\n");
        bw.flush();
    }
}
