
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int             T  = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            br.readLine();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] sejunArr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                // 세준이의 병사들
                sejunArr[i] = Integer.parseInt(st.nextToken());
            }

            int[] sebiArr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                // 세비의 병사들
                sebiArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sejunArr);
            Arrays.sort(sebiArr);

            // 전투
            int sejunCount = 0, sebiCount = 0;
            while (sejunCount < N && sebiCount < M) {
                if (sejunArr[sejunCount] < sebiArr[sebiCount]) {
                    sejunCount++;
                } else if (sejunArr[sejunCount] > sebiArr[sebiCount]) {
                    sebiCount++;
                } else {
                    sebiCount++;
                }
            }
            //
            if (sejunCount == N && sebiCount < M) {
                bw.write("B\n");
            } else if (sejunCount < N && sebiCount == M) {
                bw.write("S\n");
            } else {
                bw.write("C\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}