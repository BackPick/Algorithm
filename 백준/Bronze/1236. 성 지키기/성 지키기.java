import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) grid[i] = br.readLine();
        long emptyRows = Arrays.stream(grid).filter(s -> !s.contains("X")).count();
        int emptyCols = (int) IntStream.range(0, M).filter(j -> Arrays.stream(grid).allMatch(s -> s.charAt(j) != 'X')).count();
        int ans = (int) Math.max(emptyRows, emptyCols);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
