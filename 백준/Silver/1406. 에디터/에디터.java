import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 I/O
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 왼쪽 스택, 오른쪽 스택을 StringBuilder 로 구현
        StringBuilder left  = new StringBuilder();
        StringBuilder right = new StringBuilder();

        // 초기 문자열을 왼쪽 스택에 넣기
        left.append(br.readLine());

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            switch (cmd) {
                case 'L':  // 커서를 왼쪽으로
                    if (left.length() > 0) {
                        // 왼쪽 스택의 마지막 문자 꺼내서 오른쪽 스택에 push
                        char c = left.charAt(left.length() - 1);
                        left.setLength(left.length() - 1);
                        right.append(c);
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로
                    if (right.length() > 0) {
                        char c = right.charAt(right.length() - 1);
                        right.setLength(right.length() - 1);
                        left.append(c);
                    }
                    break;
                case 'B':  // 백스페이스
                    if (left.length() > 0) {
                        left.setLength(left.length() - 1);
                    }
                    break;
                case 'P':  // 문자 삽입
                    char x = line.charAt(2);
                    left.append(x);
                    break;
            }
        }

        // 최종 결과: 왼쪽 스택 + (오른쪽 스택을 뒤집어서)
        bw.write(left.toString());
        bw.write(right.reverse().toString());
        bw.flush();
    }
}
