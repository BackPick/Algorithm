import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static String expr;
    static int idx;

    static double parse() {
        while (idx < expr.length() && expr.charAt(idx) == ' ') idx++;
        if (expr.charAt(idx) == '(') {
            idx++;
            double p = Double.parseDouble(nextToken());
            double v1 = parse(), v2 = parse();
            while (expr.charAt(idx) == ' ') idx++;
            idx++;
            return v1 + (2*p - 1) * v2;
        } else {
            return Double.parseDouble(nextToken());
        }
    }

    static String nextToken() {
        while (idx < expr.length() && expr.charAt(idx) == ' ') idx++;
        int start = idx;
        while (idx < expr.length() && expr.charAt(idx)!=' ' && expr.charAt(idx)!=')' && expr.charAt(idx)!='(') idx++;
        return expr.substring(start, idx);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("()")) {
            expr = line.trim(); idx = 0;
            double val = parse();
            System.out.printf("%.2f%n", val);
        }
    }
}
