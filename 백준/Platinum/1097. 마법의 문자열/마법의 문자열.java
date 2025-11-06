import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    static int N, K;
    static String[] S;
    static boolean[] visited;
    static int[] permutation;
    static long totalMagicCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new String[N];
        visited = new boolean[N];
        permutation = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());

        generatePermutations(0);

        bw.write(totalMagicCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void generatePermutations(int depth) {
        if (depth == N) {
            StringBuilder tBuilder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                tBuilder.append(S[permutation[i]]);
            }
            String T = tBuilder.toString();
            if (isMagic(T, K)) {
                totalMagicCount++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = i;
                generatePermutations(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isMagic(String T, int K) {
        int L = T.length();
        if (L == 0) return false;

        String S = T + T;
        int[] pi = getPi(T);
        int count = 0;
        int j = 0;

        for (int i = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != T.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == T.charAt(j)) {
                if (j == L - 1) {
                    int startIndex = i - (L - 1);
                    if (startIndex < L) {
                        count++;
                    }
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return (count == K);
    }

    private static int[] getPi(String P) {
        int m = P.length();
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }
}