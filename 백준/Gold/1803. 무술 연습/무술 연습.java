import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[] aToB = new int[m];
        int[] bToA = new int[n];
        
        s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            aToB[i] = Integer.parseInt(s[i]) - 1;
        }
        
        s = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            bToA[j] = Integer.parseInt(s[j]) - 1;
        }
        
        int[] degA = new int[m];
        int[] degB = new int[n];
        
        for (int j = 0; j < n; j++) {
            int i_target = bToA[j];
            if (i_target >= 0 && i_target < m) {
                degA[i_target]++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            int j_target = aToB[i];
            if (j_target >= 0 && j_target < n) {
                degB[j_target]++;
            }
        }
        
        int[] A_ans = new int[m];
        int[] B_ans = new int[n];
        Arrays.fill(A_ans, -1);
        Arrays.fill(B_ans, -1);
        
        Queue<Integer> qA = new LinkedList<>();
        Queue<Integer> qB = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            if (degA[i] == 0 && A_ans[i] == -1) {
                A_ans[i] = 1;
                int j = aToB[i];
                if (j >= 0 && j < n && B_ans[j] == -1) {
                    B_ans[j] = 0;
                    qB.add(j);
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (degB[j] == 0 && B_ans[j] == -1) {
                B_ans[j] = 1;
                int i = bToA[j];
                if (i >= 0 && i < m && A_ans[i] == -1) {
                    A_ans[i] = 0;
                    qA.add(i);
                }
            }
        }
        
        while (!qA.isEmpty() || !qB.isEmpty()) {
            while (!qA.isEmpty()) {
                int i = qA.poll();
                int j = aToB[i];
                if (j < 0 || j >= n) continue;
                degB[j]--;
                if (degB[j] == 0 && B_ans[j] == -1) {
                    B_ans[j] = 1;
                    int next_i = bToA[j];
                    if (next_i >= 0 && next_i < m && A_ans[next_i] == -1) {
                        A_ans[next_i] = 0;
                        qA.add(next_i);
                    }
                }
            }
            while (!qB.isEmpty()) {
                int j = qB.poll();
                int i = bToA[j];
                if (i < 0 || i >= m) continue;
                degA[i]--;
                if (degA[i] == 0 && A_ans[i] == -1) {
                    A_ans[i] = 1;
                    int next_j = aToB[i];
                    if (next_j >= 0 && next_j < n && B_ans[next_j] == -1) {
                        B_ans[next_j] = 0;
                        qB.add(next_j);
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (A_ans[i] == -1) {
                A_ans[i] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            if (B_ans[j] == -1) {
                B_ans[j] = 1;
            }
        }
        
        StringBuilder sbA = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sbA.append(A_ans[i]);
        }
        StringBuilder sbB = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sbB.append(B_ans[j]);
        }
        
        System.out.println(sbA.toString());
        System.out.println(sbB.toString());
    }
}