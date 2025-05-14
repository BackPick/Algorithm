import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int count = 0;

        // 1) 첫 단계: 문자열 순회로 합 계산
        int sum = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            sum += s.charAt(i) - '0';
        }

        // 문자열이 두 자리 이상일 때만 count++
        if (s.length() >= 2) count++;

        // 2) 이후 단계: sum 이 두 자리 이상이면 반복
        while (sum >= 10) {
            int t = sum;
            int next = 0;
            // 자릿수 합만 정수 연산으로
            while (t > 0) {
                next += t % 10;
                t /= 10;
            }
            sum = next;
            count++;
        }

        // 결과 출력
        bw.write(count + "\n");
        bw.write((sum % 3 == 0) ? "YES" : "NO");
        bw.flush();
    }
}
