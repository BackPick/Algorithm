import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N;
    static int[] vals;
    static int[] counts;
    static int K;
    static int[] result;
    static Set<String> memo = new HashSet<>();

    static boolean dfs(int pos, int lastIdx) {
        if (pos == N) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(lastIdx).append('|');
        for (int x : counts) { sb.append(x).append(','); }
        String key = sb.toString();
        if (memo.contains(key)) return false;
        for (int i = 0; i < K; i++) {
            if (counts[i] == 0) continue;
            if (lastIdx != -1 && vals[lastIdx] + 1 == vals[i]) continue;
            counts[i]--;
            result[pos] = vals[i];
            if (dfs(pos + 1, i)) return true;
            counts[i]++;
        }
        memo.add(key);
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int v : arr) map.put(v, map.getOrDefault(v, 0) + 1);
        K = map.size();
        vals = new int[K];
        counts = new int[K];
        int idx = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            vals[idx] = e.getKey();
            counts[idx] = e.getValue();
            idx++;
        }
        result = new int[N];
        memo.clear();
        dfs(0, -1);
        for (int i = 0; i < N; i++) {
            if (i > 0) bw.write(" ");
            bw.write(String.valueOf(result[i]));
        }
        bw.newLine();
        bw.flush();
    }
}
