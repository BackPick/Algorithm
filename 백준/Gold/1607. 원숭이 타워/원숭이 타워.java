import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int mod = 9901;

        long[] dp = new long[n + 1];

        if (n == 0) {
            bw.write("0\n");
        } else {
            dp[1] = 1;
            
            int groupSize = 1;
            int countInGroup = 1;
            long diff = 1;

            for (int i = 2; i <= n; i++) {
                
                countInGroup++;
                
                if (countInGroup > groupSize) {
                    groupSize++;
                    countInGroup = 1;
                    diff = (diff * 2) % mod;
                }
                
                dp[i] = (dp[i - 1] + diff) % mod;
            }
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}