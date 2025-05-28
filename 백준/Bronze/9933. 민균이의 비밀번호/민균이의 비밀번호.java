

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringBuilder  sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set.add(word);

            String reverseWord = new StringBuilder(word).reverse()
                    .toString();

            if (set.contains(reverseWord)) {
                bw.write(reverseWord.length() + " " + reverseWord.charAt(reverseWord.length() / 2));
                break;
            }

        }

        bw.flush();
    }
}