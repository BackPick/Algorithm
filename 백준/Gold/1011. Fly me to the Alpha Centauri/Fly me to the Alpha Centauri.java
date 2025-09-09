import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long dist = y - x;

            long k = (long) Math.sqrt(dist);
            if (k * k == dist) {
                sb.append(2 * k - 1).append("\n");
            } else if (dist <= k * k + k) {
                sb.append(2 * k).append("\n");
            } else {
                sb.append(2 * k + 1).append("\n");
            }
        }

        System.out.print(sb);
    }
}
