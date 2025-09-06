import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(parts[i]);
        int S = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;
            for (int j = i+1; j < N && j-i <= S; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            for (int j = maxIdx; j > i; j--) {
                int tmp = arr[j]; arr[j] = arr[j-1]; arr[j-1] = tmp;
            }
            S -= (maxIdx - i);
        }

        for (int i = 0; i < N; i++) {
            if (i > 0) bw.write(" ");
            bw.write(String.valueOf(arr[i]));
        }
        bw.flush();
    }
}
