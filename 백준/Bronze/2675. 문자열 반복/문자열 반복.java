import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 3일차 - 1
        // https://www.acmicpc.net/problem/2605

        // 반복 횟수 R, 문자열 S, 새 문자열 P
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int             n  = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int    r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++) {
                for(int k = 0; k < r; k++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
