import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        if (N % 2 == 0 || N % 5 == 0) {
            bw.write("-1\n");
            bw.flush();
            return;
        }
        int r = 1 % N;
        for (int len = 1; len <= N; len++) {
            if (r == 0) {
                bw.write(String.valueOf(len));
                bw.newLine();
                bw.flush();
                return;
            }
            r = (r * 10 + 1) % N;
        }
        bw.write("-1\n");
        bw.flush();
    }
}
