import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dice = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        if (N == 1) {
            long sum = Arrays.stream(dice).sum();
            long max = Arrays.stream(dice).max().getAsLong();
            System.out.println(sum - max);
            return;
        }

        long min1 = Arrays.stream(dice).min().getAsLong();

        int[][] pairs = {
                {0,1},{0,2},{0,3},{0,4},
                {1,2},{1,3},{1,5},{2,4},
                {2,5},{3,4},{3,5},{4,5}
        };
        long min2 = Arrays.stream(pairs)
                .mapToLong(p -> dice[p[0]] + dice[p[1]])
                .min().getAsLong();

        int[][] triples = {
                {0,1,2},{0,1,3},{0,2,4},{0,3,4},
                {1,2,5},{1,3,5},{2,4,5},{3,4,5}
        };
        long min3 = Arrays.stream(triples)
                .mapToLong(t -> dice[t[0]] + dice[t[1]] + dice[t[2]])
                .min().getAsLong();

        long count3 = 4;
        long count2 = (long)(8 * N - 12);
        long count1 = (long)(5L * N * N - 16L * N + 12);

        long ans = min3 * count3 + min2 * count2 + min1 * count1;
        System.out.println(ans);
    }
}
