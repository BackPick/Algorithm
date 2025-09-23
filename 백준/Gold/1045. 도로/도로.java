import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static class UF {
        int[] p;
        UF(int n){ p = IntStream.range(0,n).toArray(); }
        int find(int x){ return p[x]==x?x:(p[x]=find(p[x])); }
        void uni(int a,int b){ a=find(a); b=find(b); if(a!=b) p[b]=a; }
        int countRoots(){
            return (int)IntStream.range(0,p.length).map(this::find).distinct().count();
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char[][] mat=new char[N][];
        for(int i=0;i<N;i++) mat[i]=br.readLine().trim().toCharArray();
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<N;i++) for(int j=i+1;j<N;j++) if(mat[i][j]=='Y') edges.add(new int[]{i,j});
        int E=edges.size();
        boolean[] chosen=new boolean[E];
        int chosenCount=0;
        for(int i=0;i<E && chosenCount < M;i++){
            int[] cand = edges.get(i);
            int candU=cand[0], candV=cand[1];
            int candChosenCount = chosenCount + 1;
            int m_left = M - candChosenCount;
            int availableCount = E - (i + 1);
            if (m_left < 0 || availableCount < 0) continue;
            UF ufAll = new UF(N);
            for(int idx=0; idx<E; idx++){
                if(idx < i){
                    if(chosen[idx]){
                        int[] e=edges.get(idx);
                        ufAll.uni(e[0], e[1]);
                    }
                } else if (idx == i){
                    ufAll.uni(candU, candV);
                } else {
                    int[] e=edges.get(idx);
                    ufAll.uni(e[0], e[1]);
                }
            }
            if(ufAll.countRoots() != 1) continue;
            UF ufR = new UF(N);
            for(int idx=0; idx<E; idx++){
                if(idx < i && chosen[idx]){
                    int[] e=edges.get(idx);
                    ufR.uni(e[0], e[1]);
                }
            }
            ufR.uni(candU, candV);
            int compR = ufR.countRoots();
            int need = compR - 1;
            if(m_left >= need && m_left <= availableCount){
                chosen[i] = true;
                chosenCount++;
            }
        }
        if(chosenCount < M){
            System.out.println(-1);
            return;
        }
        int[] cnt = new int[N];
        for(int i=0;i<E;i++) if(chosen[i]){
            int[] e=edges.get(i);
            cnt[e[0]]++;
            cnt[e[1]]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(i>0) sb.append(' ');
            sb.append(cnt[i]);
        }
        System.out.println(sb.toString());
    }
}
