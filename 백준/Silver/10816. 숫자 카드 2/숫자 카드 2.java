import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int             n1 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            int n2 = Integer.parseInt(st.nextToken());
            map.put(n2, map.getOrDefault(n2, 0) + 1);
        }
        int           n3 = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n3; i++) {
            int     n4     = Integer.parseInt(st.nextToken());
            Integer result = map.getOrDefault(n4, 0);
            sb.append(result).append(" ");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }
}
