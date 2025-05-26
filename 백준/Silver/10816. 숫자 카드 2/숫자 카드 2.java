

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();

        int             n  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int inputCard = Integer.parseInt(st.nextToken());
            map.put(inputCard, map.getOrDefault(inputCard, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int outputCard = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(outputCard, 0))
                    .append(" ");
        }

        bw.write(sb.toString()
                         .trim());
        bw.flush();

    }
}
