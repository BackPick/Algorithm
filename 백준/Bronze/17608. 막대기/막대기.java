import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        int maxHeight = 0;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                count++;
                maxHeight = heights[i];
            }
        }

        System.out.println(count);
    }
}
