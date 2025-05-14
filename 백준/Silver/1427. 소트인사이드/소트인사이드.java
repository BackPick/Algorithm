import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        String N = scanner.nextLine();
        
        // 각 자리수를 문자 배열로 변환
        Character[] digits = new Character[N.length()];
        for (int i = 0; i < N.length(); i++) {
            digits[i] = N.charAt(i);
        }
        
        // 내림차순으로 정렬
        Arrays.sort(digits, Collections.reverseOrder());
        
        // 정렬된 배열을 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char digit : digits) {
            result.append(digit);
        }
        
        // 결과 출력
        System.out.println(result.toString());
    }
}