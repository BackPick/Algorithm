
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2
        int                  testCase = Integer.parseInt(br.readLine());
        Map<String, Integer> clothDB  = new HashMap<>();

        for (int i = 0; i < testCase; i++) {

            // 3
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st        = new StringTokenizer(br.readLine());
                String          cloth     = st.nextToken();
                String          clothType = st.nextToken();
                clothDB.put(clothType, clothDB.getOrDefault(clothType, 0) + 1);
            }
            int result = 1;
            for (Integer value : clothDB.values()) {
                result *= (value + 1);
            }
            System.out.println(result - 1);


            clothDB.clear();
        }

    }
}
