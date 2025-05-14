import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr       = new int[N];
        int[] resultArr = new int[N];

        // 좌표 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬된 배열을 만들기 위해 복사
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); // 정렬

        // 좌표 압축을 위한 맵
        Map<Integer, Integer> map  = new HashMap<>();
        int                   rank = 0;

        // 중복을 제거하며 순위를 매김
        for (int value : sortedArr) {
            if (!map.containsKey(value)) {
                map.put(value, rank++);
            }
        }

        // 결과 배열에 좌표 압축 값을 저장
        for (int i = 0; i < N; i++) {
            resultArr[i] = map.get(arr[i]);
        }

        // 결과를 한 줄로 출력
        for (int i = 0; i < N; i++) {
            bw.write(resultArr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
