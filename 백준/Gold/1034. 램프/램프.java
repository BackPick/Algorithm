import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        String[] rows = new String[N];
        for (int i = 0; i < N; i++) rows[i] = br.readLine().trim();
        int K = Integer.parseInt(br.readLine().trim());

        Map<String, Long> freq = Arrays.stream(rows).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        int ans = 0;
        for (String row : freq.keySet()) {
            int zeroCount = (int) row.chars().filter(c -> c == '0').count();
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                ans = Math.max(ans, freq.get(row).intValue());
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
    