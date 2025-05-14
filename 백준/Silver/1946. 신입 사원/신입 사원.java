
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int             T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int     N            = Integer.parseInt(br.readLine());
            int[][] interviewArr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st                 = new StringTokenizer(br.readLine());
                interviewArr[j][0] = Integer.parseInt(st.nextToken());
                interviewArr[j][1] = Integer.parseInt(st.nextToken());
            }

            // a[0]을 기준으로 오름정력
            Arrays.sort(interviewArr, Comparator.comparingInt(a -> a[0]));

            int passCount = 0;
            int minRank   = Integer.MAX_VALUE;
            // 등수 배교
            for (int j = 0; j < N; j++) {
                int interviewRank = interviewArr[j][1];
                if (interviewRank < minRank) {
                    minRank = interviewRank;
                    passCount++;
                }
            }
            System.out.println(passCount);

        }

    }
}