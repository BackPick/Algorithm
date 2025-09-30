import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] s = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (N == 1) {
            bw.write("A\n");
            bw.flush();
            return;
        }
        if (N == 2) {
            if (s[0] == s[1]) bw.write(s[0] + "\n");
            else bw.write("A\n");
            bw.flush();
            return;
        }
        long s0 = s[0], s1 = s[1], s2 = s[2];
        if (s1 - s0 == 0) {
            boolean allEqual = IntStream.range(0, N - 1).allMatch(i -> s[i] == s[i + 1]);
            if (!allEqual) {
                bw.write("B\n");
                bw.flush();
                return;
            } else {
                bw.write(s[0] + "\n");
                bw.flush();
                return;
            }
        } else {
            long num = s2 - s1;
            long den = s1 - s0;
            if (num % den != 0) {
                bw.write("B\n");
                bw.flush();
                return;
            }
            long a = num / den;
            long b = s1 - a * s0;
            for (int i = 0; i < N - 1; i++) {
                if (s[i + 1] != a * s[i] + b) {
                    bw.write("B\n");
                    bw.flush();
                    return;
                }
            }
            long next = a * s[N - 1] + b;
            bw.write(String.valueOf(next) + "\n");
            bw.flush();
        }
    }
}
