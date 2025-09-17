import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long val;
        long cnt;
        int g;
        int side;
        Node(long v,long c,int g,int s){val=v;cnt=c;this.g=g;side=s;}
    }
    static long calcCnt(long x,long L,long R){ return (x - L) * (R - x) - 1; }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Lsize = Integer.parseInt(br.readLine().trim());
        long[] S = new long[Lsize];
        int idx = 0;
        StringTokenizer st = new StringTokenizer("");
        while (idx < Lsize) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            S[idx++] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(S);
        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if (a.cnt != b.cnt) return Long.compare(a.cnt, b.cnt);
            return Long.compare(a.val, b.val);
        });
        HashSet<Long> pushed = new HashSet<>();
        for (int i = 0; i < Lsize; i++) {
            long v = S[i];
            if (pushed.add(v)) pq.add(new Node(v, 0L, -1, 0));
        }
        int G = Lsize;
        long[] Ls = new long[G];
        long[] Rs = new long[G];
        for (int g = 0; g < G; g++) {
            Ls[g] = (g == 0) ? 0 : S[g - 1];
            Rs[g] = S[g];
        }
        long[] leftPtr = new long[G];
        long[] rightPtr = new long[G];
        for (int g = 0; g < G; g++) {
            leftPtr[g] = Ls[g] + 1;
            rightPtr[g] = Rs[g] - 1;
            if (leftPtr[g] <= rightPtr[g]) {
                long x = leftPtr[g];
                long c = calcCnt(x, Ls[g], Rs[g]);
                if (pushed.add(x)) pq.add(new Node(x, c, g, 1));
                long y = rightPtr[g];
                if (y != x) {
                    long c2 = calcCnt(y, Ls[g], Rs[g]);
                    if (pushed.add(y)) pq.add(new Node(y, c2, g, 2));
                }
            }
        }
        ArrayList<Long> ans = new ArrayList<>();
        HashSet<Long> used = new HashSet<>();
        while (ans.size() < n && !pq.isEmpty()) {
            Node cur = pq.poll();
            if (used.contains(cur.val)) continue;
            ans.add(cur.val);
            used.add(cur.val);
            if (cur.g == -1) continue;
            int g = cur.g;
            if (cur.side == 1) {
                leftPtr[g] = leftPtr[g] + 1;
                if (leftPtr[g] <= rightPtr[g]) {
                    long nv = leftPtr[g];
                    if (pushed.add(nv)) {
                        long nc = calcCnt(nv, Ls[g], Rs[g]);
                        pq.add(new Node(nv, nc, g, 1));
                    }
                }
            } else if (cur.side == 2) {
                rightPtr[g] = rightPtr[g] - 1;
                if (leftPtr[g] <= rightPtr[g]) {
                    long nv = rightPtr[g];
                    if (pushed.add(nv)) {
                        long nc = calcCnt(nv, Ls[g], Rs[g]);
                        pq.add(new Node(nv, nc, g, 2));
                    }
                }
            }
        }
        long curVal = S[Lsize - 1] + 1;
        while (ans.size() < n) {
            if (!used.contains(curVal) && !pushed.contains(curVal)) {
                ans.add(curVal);
                used.add(curVal);
            }
            curVal++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans.get(i));
        }
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
    }
}
