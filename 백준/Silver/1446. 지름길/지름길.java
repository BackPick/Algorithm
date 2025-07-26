import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Shortcut {
    int start;
    int end;
    int length;

    public Shortcut(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            shortcuts.add(new Shortcut(start, end, length));
        }

        int[] dp = new int[D + 1];
        final int INF = 100000000;
        for (int i = 1; i <= D; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i = 0; i <= D; i++) {
            if (i < D) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            for (Shortcut sc : shortcuts) {
                if (sc.start == i && sc.end <= D) {
                    dp[sc.end] = Math.min(dp[sc.end], dp[i] + sc.length);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
