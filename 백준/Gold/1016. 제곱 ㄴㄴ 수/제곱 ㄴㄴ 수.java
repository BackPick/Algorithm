import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int range = (int)(max - min + 1);
        boolean[] marked = new boolean[range]; // true면 제곱수로 나눠떨어짐

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = min % square == 0 ? min : ((min / square) + 1) * square;

            for (long j = start; j <= max; j += square) {
                marked[(int)(j - min)] = true;
            }
        }

        long count = 0;
        for (int i = 0; i < range; i++) {
            if (!marked[i]) count++;
        }

        System.out.println(count);
    }
}
