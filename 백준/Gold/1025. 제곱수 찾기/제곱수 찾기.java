import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) grid[i] = br.readLine().toCharArray();

        BigInteger best = BigInteger.valueOf(-1);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        StringBuilder sb = new StringBuilder();
                        int rr = r, cc = c;
                        while (0 <= rr && rr < N && 0 <= cc && cc < M) {
                            sb.append(grid[rr][cc]);
                            BigInteger num = new BigInteger(sb.toString());
                            if (isSquare(num) && num.compareTo(best) > 0)
                                best = num;
                            rr += dr;
                            cc += dc;
                        }
                    }
                }
            }
        }
        System.out.println(best);
    }

    static boolean isSquare(BigInteger x) {
        if (x.compareTo(BigInteger.ZERO) < 0) return false;
        BigInteger r = bigIntSqRootFloor(x);
        return r.multiply(r).equals(x);
    }

    static BigInteger bigIntSqRootFloor(BigInteger x) {
        BigInteger r = BigInteger.ZERO;
        BigInteger bit = BigInteger.ONE.shiftLeft(x.bitLength() / 2 + 1);
        while (bit.compareTo(BigInteger.ZERO) > 0) {
            BigInteger t = r.add(bit);
            if (t.multiply(t).compareTo(x) <= 0) r = t;
            bit = bit.shiftRight(1);
        }
        return r;
    }
}
