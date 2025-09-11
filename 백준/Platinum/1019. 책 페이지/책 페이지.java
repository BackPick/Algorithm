import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long[] counts = new long[10];
        long factor = 1;

        while (N / factor > 0) {
            long left = N / (factor * 10);
            long cur = (N / factor) % 10;
            long right = N % factor;

            for (int d = 0; d < 10; d++) {
                if (d == 0) {
                    if (left == 0) continue;
                    if (cur == 0) {
                        counts[d] += (left - 1) * factor + (right + 1);
                    } else {
                        counts[d] += left * factor;
                    }
                } else {
                    if (cur > d) {
                        counts[d] += (left + 1) * factor;
                    } else if (cur == d) {
                        counts[d] += left * factor + (right + 1);
                    } else {
                        counts[d] += left * factor;
                    }
                }
            }
            factor *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(counts[i]);
            if (i < 9) sb.append(" ");
        }
        System.out.println(sb);

        sc.close();
    }
}
