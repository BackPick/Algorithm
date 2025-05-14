


import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Set<String>     set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String line = br.readLine();
            set.add(line);

            String line_reverse = new StringBuilder(line).reverse()
                    .toString();
            if (set.contains(line_reverse)) {
                System.out.println(line_reverse.length() + " " + line_reverse.charAt(line_reverse.length() / 2));
                break;
            }
        }
    }
}