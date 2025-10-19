import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            boolean[] seen = new boolean[26];
            char prev = 0;
            boolean ok = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != prev) {
                    if (seen[c - 'a']) { ok = false; break; }
                    seen[c - 'a'] = true;
                    prev = c;
                } else {
                    prev = c;
                }
            }
            if (ok) count++;
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }
}
