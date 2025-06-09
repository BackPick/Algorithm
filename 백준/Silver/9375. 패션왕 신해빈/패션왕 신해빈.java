

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

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int                  n   = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st       = new StringTokenizer(br.readLine());
                String          cloth    = st.nextToken();
                String          wearType = st.nextToken();
                map.put(wearType, map.getOrDefault(wearType, 0) + 1);
            }

            int result = 1;
            for (Integer value : map.values()) {
                result *= (value + 1);
            }
            bw.write(String.valueOf(result - 1));
            bw.newLine();
        }

        bw.flush();
    }
}
