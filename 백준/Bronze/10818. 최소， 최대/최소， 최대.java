import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br     = new BufferedReader(new InputStreamReader(System.in));
        int            minNum = Integer.MAX_VALUE;
        int            maxNum = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine()
                .split(" ");


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(line[i]);
            if (num < minNum) {
                minNum = num;
            }
            if (num > maxNum) {
                maxNum = num;
            }
        }
        System.out.print(minNum + " " + maxNum);
    }
}