
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 3일차 -2
        // https://www.acmicpc.net/problem/26041
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전화번호 input
        StringTokenizer st          = new StringTokenizer(br.readLine());
        int             countTokens = st.countTokens();

        // 비교 할 전화번호 input
        String num = br.readLine();

        // 출력 할 count 미리 선언 후 0으로 초기화
        int count = 0;

        for (int i = 0; i < countTokens; i++) {
            String str = st.nextToken();
            // 조건1. 전화번호 num 과 다르며, 조건2 num을 접두사로 갖는 전화번호
            if (!str.equals(num) && str.startsWith(num)) {
                count++;
            }
        }
        System.out.print(count);
        br.close();
    }
}
