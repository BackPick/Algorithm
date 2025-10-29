import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int n;
    static long[][][][][][][] dp;
    static int[] initialCounts = new int[5];

    static long solve(int[] counts, int p1, int p2) {
        
        boolean allUsed = true;
        for (int i = 0; i < n; i++) {
            if (counts[i] > 0) {
                allUsed = false;
                break;
            }
        }
        if (allUsed) {
            return 1L;
        }
        
        int c0 = counts[0];
        int c1 = counts[1];
        int c2 = counts[2];
        int c3 = counts[3];
        int c4 = counts[4];

        if (dp[c0][c1][c2][c3][c4][p1][p2] != -1L) {
            return dp[c0][c1][c2][c3][c4][p1][p2];
        }

        long ways = 0L;
        for (int i = 0; i < n; i++) {
            if (counts[i] > 0 && i != p1 && i != p2) {
                counts[i]--;
                ways += solve(counts, i, p1);
                counts[i]++;
            }
        }

        return dp[c0][c1][c2][c3][c4][p1][p2] = ways;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            initialCounts[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[11][11][11][11][11][6][6];
        for (long[][][][][][] arr6D : dp) {
            for (long[][][][][] arr5D : arr6D) {
                for (long[][][][] arr4D : arr5D) {
                    for (long[][][] arr3D : arr4D) {
                        for (long[][] arr2D : arr3D) {
                            for (long[] arr1D : arr2D) {
                                Arrays.fill(arr1D, -1L);
                            }
                        }
                    }
                }
            }
        }
        
        long result = solve(initialCounts, 5, 5); 

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}