import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] wordMasks;
    static int maxWords = 0;
    static List<Integer> candidates = new ArrayList<>();

    static void dfs(int idx, int learned, int mask) {
        if (learned > K) return;
        if (learned == K || idx == candidates.size()) {
            int count = 0;
            for (int wm : wordMasks) if ((wm & ~mask) == 0) count++;
            maxWords = Math.max(maxWords, count);
            return;
        }
        dfs(idx + 1, learned + 1, mask | (1 << candidates.get(idx)));
        dfs(idx + 1, learned, mask);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        if (K == 26) {
            bw.write(N + "\n");
            bw.flush();
            return;
        }

        wordMasks = new int[N];
        boolean[] used = new boolean[26];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (int j = 4; j < word.length() - 4; j++) {
                int c = word.charAt(j) - 'a';
                mask |= 1 << c;
                used[c] = true;
            }
            wordMasks[i] = mask;
        }

        for (int i = 0; i < 26; i++) {
            if (i == 'a' - 'a' || i == 'n' - 'a' || i == 't' - 'a' || i == 'i' - 'a' || i == 'c' - 'a') continue;
            if (used[i]) candidates.add(i);
        }

        int baseMask = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('c' - 'a'));
        dfs(0, 5, baseMask);

        bw.write(maxWords + "\n");
        bw.flush();
    }
}
