
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer           st      = new StringTokenizer(br.readLine());
        int                       N       = Integer.parseInt(st.nextToken());
        int                       M       = Integer.parseInt(st.nextToken());
        Map<String, List<String>> nameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // Skip first token
            String name      = st.nextToken();
            String resultKey = st.nextToken() + st.nextToken() + st.nextToken();
            nameMap.putIfAbsent(resultKey, new ArrayList<>());
            nameMap.get(resultKey)
                    .add(name);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            String       key          = sb.toString();
            List<String> matchedNames = nameMap.getOrDefault(key, Collections.emptyList());

            if (matchedNames.size() == 1) {
                bw.write(matchedNames.get(0));
                bw.newLine();
            } else if (matchedNames.size() > 1) {
                bw.write("?");
                bw.newLine();
            } else {
                bw.write("!");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
