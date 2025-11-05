import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] grid;
    static long[] rowSum;
    static long[] colSum;
    static long maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        rowSum = new long[N];
        colSum = new long[N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
                rowSum[r] += grid[r][c];
                colSum[c] += grid[r][c];
            }
        }

        solveSameRowOrCol();
        solveDifferentRowAndCol();

        bw.write(maxScore + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solveSameRowOrCol() {
        for (int r = 0; r < N; r++) {
            long[] vals = new long[N];
            for (int c = 0; c < N; c++) {
                vals[c] = colSum[c] - 2L * grid[r][c];
            }
            long[] maxTwo = findMaxTwo(vals);
            maxScore = Math.max(maxScore, rowSum[r] + maxTwo[0] + maxTwo[1]);
        }

        for (int c = 0; c < N; c++) {
            long[] vals = new long[N];
            for (int r = 0; r < N; r++) {
                vals[r] = rowSum[r] - 2L * grid[r][c];
            }
            long[] maxTwo = findMaxTwo(vals);
            maxScore = Math.max(maxScore, colSum[c] + maxTwo[0] + maxTwo[1]);
        }
    }

    private static void solveDifferentRowAndCol() {
        for (int r1 = 0; r1 < N; r1++) {
            for (int r2 = r1 + 1; r2 < N; r2++) {
                long[] termA = new long[N];
                long[] termB = new long[N];
                for (int c = 0; c < N; c++) {
                    termA[c] = (long)colSum[c] - 2L * grid[r1][c] - (long)grid[r2][c];
                    termB[c] = (long)colSum[c] - 2L * grid[r2][c] - (long)grid[r1][c];
                }
                
                long maxSumC = findMaxSumDifferentIndices(termA, termB);
                maxScore = Math.max(maxScore, rowSum[r1] + rowSum[r2] + maxSumC);
            }
        }
    }

    private static long[] findMaxTwo(long[] vals) {
        long max1 = -Long.MAX_VALUE;
        long max2 = -Long.MAX_VALUE;
        for (long val : vals) {
            if (val > max1) {
                max2 = max1;
                max1 = val;
            } else if (val > max2) {
                max2 = val;
            }
        }
        return new long[]{max1, max2};
    }

    private static long findMaxSumDifferentIndices(long[] A, long[] B) {
        long maxA = -Long.MAX_VALUE;
        long secMaxA = -Long.MAX_VALUE;
        int idxA = -1;

        long maxB = -Long.MAX_VALUE;
        long secMaxB = -Long.MAX_VALUE;
        int idxB = -1;

        for (int i = 0; i < N; i++) {
            if (A[i] > maxA) {
                secMaxA = maxA;
                maxA = A[i];
                idxA = i;
            } else if (A[i] > secMaxA) {
                secMaxA = A[i];
            }

            if (B[i] > maxB) {
                secMaxB = maxB;
                maxB = B[i];
                idxB = i;
            } else if (B[i] > secMaxB) {
                secMaxB = B[i];
            }
        }

        if (idxA != idxB) {
            return maxA + maxB;
        } else {
            return Math.max(maxA + secMaxB, secMaxA + maxB);
        }
    }
}