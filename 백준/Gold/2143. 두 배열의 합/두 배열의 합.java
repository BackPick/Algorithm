

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int             n    = Integer.parseInt(br.readLine());
        int[]           arrA = new int[n];
        StringTokenizer stA  = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(stA.nextToken());
        }

        List<Long> sumA = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrA[j];
                sumA.add(sum);
            }
        }

        int             m    = Integer.parseInt(br.readLine());
        int[]           arrB = new int[m];
        StringTokenizer stB  = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(stB.nextToken());
        }
        Map<Long, Integer> sumB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrB[j];
                sumB.put(sum, sumB.getOrDefault(sum, 0) + 1);
            }
        }

        long count = 0;
        for (Long x : sumA) {
            long target = t - x;
            count += sumB.getOrDefault(target, 0);
        }
        System.out.println(count);

    }
}