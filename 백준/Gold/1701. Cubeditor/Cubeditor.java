import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int n;
    static String s;
    static Integer[] sa;
    static int[] group;
    static int[] lcp;
    static int t;

    private static void buildSuffixArray() {
        n = s.length();
        sa = new Integer[n];
        group = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            group[i] = s.charAt(i);
        }
        group[n] = -1;

        t = 1;
        while (t < n) {
            
            Comparator<Integer> comp = (i, j) -> {
                if (group[i] != group[j]) {
                    return group[i] - group[j];
                }
                int nextI = i + t;
                int nextJ = j + t;
                return group[nextI] - group[nextJ];
            };

            Arrays.sort(sa, comp);

            int[] newGroup = new int[n + 1];
            newGroup[n] = -1;
            newGroup[sa[0]] = 0;

            for (int i = 1; i < n; i++) {
                if (comp.compare(sa[i - 1], sa[i]) < 0) {
                    newGroup[sa[i]] = newGroup[sa[i - 1]] + 1;
                } else {
                    newGroup[sa[i]] = newGroup[sa[i - 1]];
                }
            }
            group = newGroup;
            
            if (group[sa[n-1]] == n - 1) break;
            
            t <<= 1;
        }
    }

    private static int buildLCPArray() {
        lcp = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int k = 0;
        int maxLCP = 0;

        for (int i = 0; i < n; i++) {
            if (rank[i] == 0) continue;

            int j = sa[rank[i] - 1];

            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }

            lcp[rank[i]] = k;
            maxLCP = Math.max(maxLCP, k);

            if (k > 0) {
                k--;
            }
        }
        return maxLCP;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        
        buildSuffixArray();
        int result = buildLCPArray();

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}