import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();
        while (list.size() < N) {
            String line = br.readLine();
            if (line == null) break;
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) if (!p.isEmpty()) list.add(Integer.parseInt(p));
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        int maxV = Arrays.stream(arr).max().orElse(0);
        int[] freq = new int[maxV + 1];
        for (int v : arr) freq[v]++;
        long ans = 0;
        for (int t = 1; t <= maxV; t++) {
            int cnt = 0;
            for (int j = t; j <= maxV; j += t) cnt += freq[j];
            if (cnt >= 2) {
                long total = (long) t * cnt;
                if (total > ans) ans = total;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
