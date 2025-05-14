
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int   N    = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        int   M    = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int result = binarySearch(arrN, arrM[i]);
            System.out.println(result);
        }


    }

    private static int binarySearch(int[] arrN, int i) {
        int start = 0, end = arrN.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrN[mid] == i) {
                return 1;
            } else if (arrN[mid] > i) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}