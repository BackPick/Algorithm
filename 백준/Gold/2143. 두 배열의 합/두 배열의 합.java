
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        long t = Long.parseLong(br.readLine());

        int             n     = Integer.parseInt(br.readLine());
        StringTokenizer nLine = new StringTokenizer(br.readLine());
        int[]           arrN  = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(nLine.nextToken());
        }

        List<Long> listN = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrN[j];
                listN.add(sum);
            }
        }
        int             m     = Integer.parseInt(br.readLine());
        StringTokenizer mLine = new StringTokenizer(br.readLine());
        int[]           arrM  = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(mLine.nextToken());
        }

        Map<Long, Integer> mapM = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrM[j];
                mapM.put(sum, mapM.getOrDefault(sum, 0) + 1);
            }
        }

        long count = 0;
        for (Long x : listN) {
            long sum = t - x;
            count += mapM.getOrDefault(sum, 0);
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}