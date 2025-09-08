import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int[] cranes = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine().trim());
        int[] boxes = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(cranes);
        Arrays.sort(boxes);
        int maxC = cranes[N-1], maxB = boxes[M-1];
        if (maxB > maxC) {
            bw.write("-1");
            bw.flush();
            return;
        }

        // 내림차순 정렬
        Integer[] cDesc = new Integer[N];
        for (int i = 0; i < N; i++) cDesc[i] = cranes[N-1-i];
        Integer[] bDesc = new Integer[M];
        for (int i = 0; i < M; i++) bDesc[i] = boxes[M-1-i];

        int time = 0;
        boolean[] used = new boolean[M];
        int moved = 0;

        while (moved < M) {
            int j = 0;
            for (int i = 0; i < N; i++) {
                while (j < M) {
                    if (!used[j] && cDesc[i] >= bDesc[j]) {
                        used[j] = true;
                        moved++;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            time++;
        }

        bw.write(String.valueOf(time));
        bw.flush();
    }
}
