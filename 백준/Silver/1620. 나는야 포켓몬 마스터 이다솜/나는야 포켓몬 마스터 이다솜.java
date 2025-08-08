import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] idxToName = new String[N + 1];            // 1-indexed
        HashMap<String, Integer> nameToIdx = new HashMap<>(N * 2); // 리사이즈 최소화

        for (int i = 1; i <= N; i++) {
            String name = br.readLine().trim();
            idxToName[i] = name;
            nameToIdx.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String q = br.readLine().trim();
            if (!q.isEmpty() && Character.isDigit(q.charAt(0))) {
                int idx = Integer.parseInt(q);
                sb.append(idxToName[idx]).append('\n');
            } else {
                sb.append(nameToIdx.get(q)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}