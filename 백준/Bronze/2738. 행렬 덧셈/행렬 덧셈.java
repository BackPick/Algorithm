import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arrA      = new int[n][m];
        int[][] arrB      = new int[n][m];
        int[][] resultArr = new int[n][m];

        // 행렬 A
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 행렬 B
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 행렬 합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultArr[i][j] = arrA[i][j] + arrB[i][j];
            }
        }
        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // System.out.print(resultArr[i][j] + " ");
                bw.write(resultArr[i][j] + " ");
            }
            bw.newLine();
            // System.out.println();
        }

        bw.flush();
    }
}
