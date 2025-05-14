import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int maxNum = Integer.MIN_VALUE;
        int row    = 0;
        int col    = 0;

        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > maxNum) {
                    maxNum = arr[i][j];
                    row    = i + 1;
                    col    = j + 1;
                }
            }
        }

        bw.write(maxNum + "\n");
        bw.write(row + " " + col);
        bw.flush();

    }
}
