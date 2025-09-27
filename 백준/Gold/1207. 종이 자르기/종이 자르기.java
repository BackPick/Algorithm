import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int L;
    static class Placement {
        int[] cells;
        BitSet bs;
        Placement(int[] c){
            cells = c;
            bs = new BitSet(L*L);
            for(int x:c) bs.set(x);
        }
    }
    static ArrayList<Placement>[] placements = new ArrayList[5];
    static int[] grid;
    static boolean[] used = new boolean[5];
    static String best = null;
    static int totalHash = 0;
    static void dfs(int placedCount){
        if(placedCount == 5){
            for(int i=0;i<L*L;i++) if(grid[i]==0) return;
            StringBuilder sb = new StringBuilder(L*L);
            for(int i=0;i<L*L;i++) sb.append((char)('0' + grid[i]));
            String cand = sb.toString();
            if(best==null || cand.compareTo(best) < 0) best = cand;
            return;
        }
        int idx = -1;
        for(int i=0;i<L*L;i++){ if(grid[i]==0){ idx = i; break; } }
        if(idx == -1){
            dfs(5); return;
        }
        for(int p=0;p<5;p++){
            if(used[p]) continue;
            ArrayList<Placement> list = placements[p];
            for(Placement pl : list){
                if(!pl.bs.get(idx)) continue;
                boolean ok = true;
                for(int c : pl.cells) if(grid[c] != 0){ ok = false; break; }
                if(!ok) continue;
                for(int c : pl.cells) grid[c] = p+1;
                used[p] = true;
                int nextEmpty = -1;
                for(int i=0;i<L*L;i++) if(grid[i]==0){ nextEmpty = i; break; }
                if(best != null){
                    boolean prune = false;
                    int prefLen = (nextEmpty == -1) ? L*L : nextEmpty;
                    for(int k=0;k<prefLen;k++){
                        char cur = (char)('0' + grid[k]);
                        char bch = best.charAt(k);
                        if(cur < bch) { prune = false; break; }
                        if(cur > bch) { prune = true; break; }
                    }
                    if(!prune) dfs(placedCount+1);
                    else {
                        used[p] = false;
                        for(int c : pl.cells) grid[c] = 0;
                        continue;
                    }
                } else dfs(placedCount+1);
                used[p] = false;
                for(int c : pl.cells) grid[c] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine().trim());
        String[][] shapes = new String[5][];
        int[] hs = new int[5], ws = new int[5];
        for(int p=0;p<5;p++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            hs[p] = h; ws[p] = w;
            shapes[p] = new String[h];
            for(int i=0;i<h;i++){
                shapes[p][i] = br.readLine();
            }
            for(int i=0;i<h;i++) for(int j=0;j<w;j++) if(shapes[p][i].charAt(j) == '#') totalHash++;
        }
        if(totalHash != L*L){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("gg\n"); bw.flush(); return;
        }
        for(int p=0;p<5;p++) placements[p] = new ArrayList<>();
        for(int p=0;p<5;p++){
            int h = hs[p], w = ws[p];
            for(int r0=0;r0<=L-h;r0++){
                for(int c0=0;c0<=L-w;c0++){
                    ArrayList<Integer> cells = new ArrayList<>();
                    for(int i=0;i<h;i++){
                        for(int j=0;j<w;j++){
                            if(shapes[p][i].charAt(j) == '#') cells.add((r0+i)*L + (c0+j));
                        }
                    }
                    if(!cells.isEmpty()){
                        int[] arr = cells.stream().mapToInt(Integer::intValue).toArray();
                        placements[p].add(new Placement(arr));
                    }
                }
            }
            if(placements[p].isEmpty()){
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                bw.write("gg\n"); bw.flush(); return;
            }
        }
        grid = new int[L*L];
        Arrays.fill(grid, 0);
        dfs(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(best == null){
            bw.write("gg\n");
        } else {
            for(int r=0;r<L;r++){
                bw.write(best.substring(r*L, r*L+L));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
