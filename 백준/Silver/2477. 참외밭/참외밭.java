import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int melon = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxWidth = 0, maxWidthIdx = -1, maxHeight = 0, maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[i] = length;

            if (direction <= 2) { // 동(1), 서(2) → 가로
                if (length > maxWidth) {
                    maxWidth = length;
                    maxWidthIdx = i;
                }
            } else { // 남(3), 북(4) → 세로
                if (length > maxHeight) {
                    maxHeight = length;
                    maxHeightIdx = i;
                }
            }
        }

        // 작은 사각형 변 계산 (모듈로 연산 최적화)
        int prev = (maxWidthIdx - 1 + 6) % 6;
        int next = (maxWidthIdx + 1) % 6;
        int smallHeight = Math.abs(arr[next] - arr[prev]);

        prev = (maxHeightIdx - 1 + 6) % 6;
        next = (maxHeightIdx + 1) % 6;
        int smallWidth = Math.abs(arr[next] - arr[prev]);

        System.out.println(((maxWidth * maxHeight) - (smallHeight * smallWidth)) * melon);
    }
}