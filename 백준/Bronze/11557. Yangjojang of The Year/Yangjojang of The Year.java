
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int            T  = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int                  N         = Integer.parseInt(br.readLine());
            Map<Integer, String> yangjoMap = new HashMap<>();
            int[]                drink     = new int[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String          S  = st.nextToken();
                int             L  = Integer.parseInt(st.nextToken());
                drink[j] = L;
                yangjoMap.put(L, S);
            }
            selectSort(drink);
            System.out.println(yangjoMap.get(drink[0]));
        }
    }

    private static void selectSort(int[] drink) {
        for (int i = 0; i < drink.length - 1; i++) {
            int index = i;
            for (int j = i; j < drink.length; j++) {
                if (drink[index] < drink[j]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = drink[i];
                drink[i]     = drink[index];
                drink[index] = temp;
            }
        }
    }
}