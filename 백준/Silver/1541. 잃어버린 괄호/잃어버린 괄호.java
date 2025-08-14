import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        
        // '-' 기호를 기준으로 식을 분리한다.
        String[] minusSplit = expression.split("-");
        
        // 첫 번째 그룹은 모두 더한다.
        int result = sumNumbers(minusSplit[0]);
        
        // 나머지 그룹들은 모두 빼준다.
        for (int i = 1; i < minusSplit.length; i++) {
            result -= sumNumbers(minusSplit[i]);
        }
        
        // 결과를 출력한다.
        System.out.println(result);
    }
    
    // 주어진 문자열 그룹을 '+' 기호로 분리하여 모든 숫자의 합을 구하는 메소드
    private static int sumNumbers(String group) {
        String[] plusSplit = group.split("\\+"); // '+'는 정규식에서 특수문자이므로 이스케이프 처리
        int sum = 0;
        for (String number : plusSplit) {
            // 문자열을 정수로 변환하여 합산
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
