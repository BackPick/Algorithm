
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 나무의 수 N. 필요한 나무의 길이 M
        st = new StringTokenizer(br.readLine());
        int    N     = Integer.parseInt(st.nextToken());
        long   M     = Long.parseLong(st.nextToken());
        long[] trees = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(binarySearch(N, trees, M));

    }

    private static long binarySearch(int N, long[] trees, long M) {
        long left = 0, right = 1000000000, getTree = 0;

        while (left <= right) {
            long mid        = (left + right) / 2;
            long totalCount = 0;

            // ■■■■■■■■■■■ <- tree
            // ■■■■■■■■■ <- mid
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) totalCount += trees[i] - mid;
            }
            if (totalCount >= M) {
                getTree = mid;
                left    = mid + 1;
            } else right = mid - 1;
        }
        return getTree;
    }
}
