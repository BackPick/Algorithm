import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용해 입력을 받아온다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        
        // 입력이 끝날 때까지 반복한다.
        while ((inputLine = reader.readLine()) != null) {
            // 첫 번째 문자열 읽기 (a)
            String a = inputLine.trim();  
            // 두 번째 문자열 읽기 (b)
            String b = reader.readLine();
            if (b == null) break;    // b가 null일 경우 루프 종료
            b = b.trim();
            
            // 각 문자열의 알파벳 빈도를 저장하기 위한 배열 준비
            int[] countA = new int[26];
            int[] countB = new int[26];
            
            // 문자열 a의 각 문자의 개수를 카운트 한다.
            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    countA[ch - 'a']++;
                }
            }
            
            // 문자열 b의 각 문자의 개수를 카운트 한다.
            for (int i = 0; i < b.length(); i++) {
                char ch = b.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    countB[ch - 'a']++;
                }
            }
            
            // 결과를 저장할 StringBuilder 준비
            StringBuilder result = new StringBuilder();
            
            // 알파벳 'a'부터 'z'까지 순서대로 공통으로 등장하는 문자를 저장한다.
            for (int i = 0; i < 26; i++) {
                // 두 문자열 모두에서 해당 문자 등장 횟수의 최소값을 구한다.
                int commonCount = Math.min(countA[i], countB[i]);
                for (int j = 0; j < commonCount; j++) {
                    result.append((char) ('a' + i));
                }
            }
            
            // 결과를 출력한다.
            System.out.println(result.toString());
        }
    }
}
