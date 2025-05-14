import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        int uniqueA = aSet.size();
        int uniqueB = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (aSet.contains(num)) {
                uniqueA--; // 교집합 원소 제외
            } else {
                uniqueB++; // B에만 있는 원소
            }
        }

        System.out.println(uniqueA + uniqueB);
    }
}