import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    static void dfs(long num, int lastDigit) {
        list.add(num);
        for (int next = 0; next < lastDigit; next++) {
            dfs(num * 10 + next, next);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }
        Collections.sort(list);

        if (N < list.size()) {
            bw.write(Long.toString(list.get(N)));
        } else {
            bw.write("-1");
        }
        bw.newLine();
        bw.flush();
    }
}
