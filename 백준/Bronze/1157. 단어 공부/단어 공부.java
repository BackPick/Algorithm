import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine().toUpperCase();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') cnt[c - 'A']++;
        }
        int max = 0;
        char ans = '?';
        boolean dup = false;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = (char)('A' + i);
                dup = false;
            } else if (cnt[i] == max) dup = true;
        }
        bw.write(dup ? "?" : String.valueOf(ans));
        bw.flush();
    }
}
